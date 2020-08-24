package cn.edu.ncu.controller;

import cn.edu.ncu.dto.GoodsAndOrderDetailDTO;
import cn.edu.ncu.dto.OrderAndAddressDTO;
import cn.edu.ncu.pojo.*;
import cn.edu.ncu.service.*;
import cn.edu.ncu.utils.IdWorker;
import cn.edu.ncu.utils.OrderNumberUtils;
import javafx.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-22.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Controller
public class GoodsOrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private OrderDetailService orderDetailService;
    @Resource
    private FreightService freightService;
    @Resource
    private FreightDetailService freightDetailService;

    @RequestMapping("/mygxin")
    public ModelAndView numberOfClassifiedOrders(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mygxin");
        User user = (User)session.getAttribute("user");
        List<Order> orders = orderService.findAllOrderByUserName(user.getUsername());
        int toBePaid = 0;
        int toBeReceived = 0;
        int toBeEvaluated = 0;
        for (Order order : orders){
            if ("1".equals(order.getStatus())){
                toBePaid ++;
            }
            if ("2".equals(order.getStatus())){
                toBeReceived ++;
            }
            if ("3".equals(order.getStatus())){
                toBeEvaluated ++;
            }
        }
        modelAndView.addObject("toBePaid",toBePaid);
        modelAndView.addObject("toBeReceived",toBeReceived);
        modelAndView.addObject("toBeEvaluated",toBeEvaluated);
        return modelAndView;
    }

    @RequestMapping("/serchOrderByOrderId")
    public ModelAndView serchOrderByOrderId(String orderId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myorderq");

        List<FreightDetail> freightDetail = freightDetailService.findFreightDetailByOrderId(orderId);
        String freightId = new String();
        if (freightDetail.size()!=0){
            freightId  = freightDetail.get(0).getFreightId();
        }

        if (orderId != null && !("".equals(orderId))){
            List<Order> orders = orderService.findOrderByOrderId(orderId);
            Map<Pair<OrderAndAddressDTO,List<FreightDetail>>,Pair<List<GoodsAndOrderDetailDTO>, Freight>> userOrder = new HashMap<>();
            for (Order order : orders){

                OrderAndAddressDTO orderAndAddress = orderService.QueryOrderAndAddressByOrderId(order.getOrderId());
                List<GoodsAndOrderDetailDTO> goodsAndOrderDetail = orderDetailService.queryGoodsAndOrderDetailByOrderId(order.getOrderId());

                List<FreightDetail> freightDetails = freightDetailService.findFreightDetailByFreightId(freightId);
                Collections.sort(freightDetails, new Comparator<FreightDetail>() {
                    @Override
                    public int compare(FreightDetail o1, FreightDetail o2) {
                        Date age1 = o1.getUpdateTime();
                        Date age2 = o2.getUpdateTime();
                        return 0-age1.compareTo(age2);
                    }
                });
                List<Freight> freights = freightService.findFreightByFreightId(Long.parseLong(freightId));
                Freight freight = null;
                if (freights.size() == 1) freight = freights.get(0);
                Pair<OrderAndAddressDTO,List<FreightDetail>> pair1 = new Pair<>(orderAndAddress,freightDetails);
                Pair<List<GoodsAndOrderDetailDTO>,Freight> pair2 = new Pair<>(goodsAndOrderDetail,freight);
                userOrder.put(pair1,pair2);
            }
            modelAndView.addObject("userOrder",userOrder);
        }
        return modelAndView;
    }

    @RequestMapping("/confirmReceipt")
    public ModelAndView confirmReceipt(String orderId,HttpSession session){
        Order order = new Order();
        List<Order> orders = orderService.findOrderByOrderId(orderId);
        if (orders.size()==1) order = orders.get(0);
        order.setStatus("3");
        orderService.updateOrder(order);
        return allGoodsOrder("1",session);
    }

    @RequestMapping("/orderDetail")
    public ModelAndView orderDetail(String orderId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orderxq");
        OrderAndAddressDTO orderAndAddress = orderService.QueryOrderAndAddressByOrderId(orderId);
        List<GoodsAndOrderDetailDTO> goodsAndOrderDetail = orderDetailService.queryGoodsAndOrderDetailByOrderId(orderId);
        Pair<OrderAndAddressDTO,List<GoodsAndOrderDetailDTO>> userOrder = new Pair<>(orderAndAddress,goodsAndOrderDetail);
        modelAndView.addObject("userOrder",userOrder);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/addGoodsOrder")
    public String addGoodsOrder(String id, String payWay,String deliverWay,HttpSession session) {
        // 生成18位订单号和16位物流号
        String orderId = OrderNumberUtils.generate18BitOrderNumber();
        Long freightId = null;
        try {
            freightId = IdWorker.getInstance().nextId();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 生成物流信息
        Freight tbFreight = new Freight();
        tbFreight.setExpressDelivery(deliverWay);
        tbFreight.setFreightId(String.valueOf(freightId));
        tbFreight.setSendTimeType("4");
        tbFreight.setCreateTime(new Date());
        freightService.addFreight(tbFreight);

        // 生成订单信息
        User sessionUser = (User)session.getAttribute("user");
        Order order = new Order();
        order.setOrderId(orderId);
        order.setPaymentType(payWay);
        order.setAddressId(BigDecimal.valueOf(Long.parseLong(id)));
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setUsername(sessionUser.getUsername());

        Cart cartOrder = (Cart)session.getAttribute("cartOrder");
        order.setPayment(BigDecimal.valueOf(cartOrder.getTotalPrice()));
        order.setPostFee(BigDecimal.valueOf(Double.parseDouble("0")));
        order.setStatus("2");
        order.setPaymentTime(new Date());
        order.setConsignTime(new Date());
        order.setEndTime(new Date());
        order.setCloseTime(new Date());
        order.setBuyerRate("0");
        /*orderService.addOrder(order);*/ // sql 不安全

        // 将用户从购物车购买的商品，生成订单详情
        String  p_goods = ""; //--
        String  p_spec = "";  //--
        String  p_num = "";  //--

        Map<Pair<Goods,String>, Pair<Integer, String>> cartOrderGoods= cartOrder.getGoods();
        for (Map.Entry<Pair<Goods,String>, Pair<Integer, String>> entry :cartOrderGoods.entrySet()){
           /* OrderDetail orderItem = new OrderDetail();
            orderItem.setGoodsId(entry.getKey().getKey().getGoodsId());
            orderItem.setOrderId(orderId);
            orderItem.setNum(BigDecimal.valueOf(entry.getValue().getKey()));
            orderItem.setSpecOption(entry.getKey().getValue());
            BigDecimal totalFee = BigDecimal.valueOf(orderItem.getNum().doubleValue()*(entry.getKey().getKey().getPrice().doubleValue()));
            orderItem.setTotalFee(totalFee);
            orderDetailService.addOrderItem(orderItem);*/ // sql 不安全
            p_goods = p_goods + entry.getKey().getKey().getGoodsId() + ","; //--
            p_num = p_num + entry.getValue().getKey() + ","; //--
            p_spec = p_spec + entry.getKey().getValue() + ","; //--
        }

        p_goods = p_goods.substring(0,p_goods.length() - 1); //--
        p_num = p_num.substring(0,p_num.length() - 1); //--
        p_spec = p_spec.substring(0,p_spec.length() - 1); //--
        orderService.addOrderAndOrderDetail(order,p_goods,p_num,p_spec); //--
        // 生成初始物流详情信息
        FreightDetail freightDetail = new FreightDetail();
        freightDetail.setFreightId(String.valueOf(freightId));
        freightDetail.setOrderId(orderId);
        freightDetail.setUpdateTime(new Date());
        freightDetail.setDetail("正在出仓");
        freightDetailService.addFreightDetail(freightDetail);
        session.removeAttribute("cartOrder"); // 将用户从购物车购买的商品从session中销毁
        return "success";
    }

    @RequestMapping("/myorderq")
    public ModelAndView allGoodsOrder(String pageNumber, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myorderq");
        User sessionUser = (User) session.getAttribute("user");
        final int pageSize = 3;
        int number = Integer.parseInt(pageNumber) <= 0 ? 1 : Integer.parseInt(pageNumber);
        int count = orderService.findAllOrderCountByUserName(sessionUser.getUsername());
        number = number < Math.ceil(count/(pageSize*(1.0))) ?
                number : (int) Math.ceil(count/ (pageSize * (1.0)));
        List<Order> orders = orderService.findAllOrderByUserName(sessionUser.getUsername(),number,pageSize);
        Map<Pair<OrderAndAddressDTO,List<FreightDetail>>,Pair<List<GoodsAndOrderDetailDTO>,Freight>> userOrder = new HashMap<>(); // userOrder：用来返回给jsp页面
        for (Order order : orders){
            // orderAndAddress：Oracle数据库t_order,t_address多表联查得到的结果集
            OrderAndAddressDTO orderAndAddress = orderService.QueryOrderAndAddressByOrderId(order.getOrderId());
            // goodsAndOrderDetail：Oracle数据库t_goods,t_order_detail多表联查得到的结果集
            List<GoodsAndOrderDetailDTO> goodsAndOrderDetail = orderDetailService.queryGoodsAndOrderDetailByOrderId(order.getOrderId());
            // 根据订单号找出对应的物流号
            List<FreightDetail> freightDetail = freightDetailService.findFreightDetailByOrderId(order.getOrderId());
            String freightId = new String();
            if (freightDetail.size()!=0){
                freightId  = freightDetail.get(0).getFreightId();
            }
            // 根据物流号查出所有的物流详情信息
            List<FreightDetail> freightDetails = freightDetailService.findFreightDetailByFreightId(freightId);
            Collections.sort(freightDetails, new Comparator<FreightDetail>() {
                @Override
                public int compare(FreightDetail o1, FreightDetail o2) {
                    Date age1 = o1.getUpdateTime();
                    Date age2 = o2.getUpdateTime();
                    return 0-age1.compareTo(age2);
                }
            });
            List<Freight> freights = freightService.findFreightByFreightId(Long.parseLong(freightId));
            Freight freight = null;
            if (freights.size() == 1) freight = freights.get(0);
            Pair<OrderAndAddressDTO,List<FreightDetail>> pair1 = new Pair<>(orderAndAddress,freightDetails);
            Pair<List<GoodsAndOrderDetailDTO>,Freight> pair2 = new Pair<>(goodsAndOrderDetail,freight);
            userOrder.put(pair1,pair2);
        }
        modelAndView.addObject("userOrder",userOrder);
        modelAndView.addObject("pageNumber",number);
        return modelAndView;
    }
}
