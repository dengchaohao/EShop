package cn.edu.ncu.controller;

import cn.edu.ncu.dto.GoodsAndOrderDetailDTO;
import cn.edu.ncu.pojo.Order;
import cn.edu.ncu.pojo.OrderDetail;
import cn.edu.ncu.pojo.User;
import cn.edu.ncu.service.OrderDetailService;
import cn.edu.ncu.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-11-12-13:11.
 * @Description: ssm
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Controller
public class CommentController {
    @Resource
    private OrderDetailService orderDetailService;
    @Resource
    private OrderService orderService;


    @RequestMapping("/updateComment")
    public ModelAndView updateComment(String orderItemId, String content, HttpSession session){
        OrderDetail orderItem = orderDetailService.findOrderItemById(Long.parseLong(orderItemId));
        orderItem.setRemark(content);
        orderItem.setCommentTime(new Date());
        orderItem.setEvaluate("1");
        orderDetailService.updateOrderItem(orderItem);
        return myprod(session);
    }

    @RequestMapping("/comment")
    public ModelAndView comment(String orderItemId, String content, HttpSession session){
        OrderDetail orderItem = orderDetailService.findOrderItemById(Long.parseLong(orderItemId));
        orderItem.setRemark(content);
        orderItem.setCommentTime(new Date());
        orderItem.setEvaluate("1");
        orderDetailService.updateOrderItem(orderItem);
        return myprod(session);
    }

    @RequestMapping("/myprod")
    public ModelAndView myprod(HttpSession session){ // 从所有已经收货的商品中找出待评价、 已经评价、评价失效的商品
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myprod");
        User sessionUser = (User) session.getAttribute("user");
        List<Order> orders = orderService.findAllOrderByUserNameAndStatus(sessionUser.getUsername(),"3"); // status 表示已收货
        List<GoodsAndOrderDetailDTO> toBeEvaluated = new ArrayList<>();
        List<GoodsAndOrderDetailDTO> evaluated = new ArrayList<>();
        List<GoodsAndOrderDetailDTO> evaluationFailure = new ArrayList<>();
        if (orders.size() != 0){
            List<String> orderIds = new ArrayList<>();
            for (Order order : orders){
                orderIds.add(order.getOrderId());
            }
            toBeEvaluated = orderDetailService.findOrderItemsByOrderIdAndEvaluate(orderIds,"0"); // evaluate 待评价
            evaluated = orderDetailService.findOrderItemsByOrderIdAndEvaluate(orderIds,"1"); // 已经评价
            evaluationFailure = orderDetailService.findOrderItemsByOrderIdAndEvaluate(orderIds,"2"); // 评价失效
        }
        modelAndView.addObject("toBeEvaluated",toBeEvaluated);
        modelAndView.addObject("evaluated",evaluated);
        modelAndView.addObject("evaluationFailure",evaluationFailure);
        return modelAndView;
    }
}
