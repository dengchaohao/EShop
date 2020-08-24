package cn.edu.ncu.test;

import cn.edu.ncu.dao.CartGoodsMapper;
import cn.edu.ncu.dao.OrderMapper;
import cn.edu.ncu.dao.RoleDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15.
 * @Description: mybatis-study-01
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public class DAOTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //UserDAO userDAO = context.getBean("userDAO", UserDAO.class);
        //User user = new User(null, "new_user", "123",null);
        //userDAO.insertUser(user);
        /*CartGoodsMapper cartGoodsMapper = context.getBean("cartGoodsMapper", CartGoodsMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("userId","羊羊羊");
        map.put("goodsId","149187842867912");
        map.put("numb",2);
        map.put("specification","白瓷花瓶和20支兔尾巴草");
        cartGoodsMapper.insertCartGoods(map);
        System.out.println(map.get("state"));*/

        OrderMapper orderMapper = context.getBean("orderMapper", OrderMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("p_goods","149187842867912,149187842867912,149187842867912");
        map.put("p_spec","20支快乐花,白瓷花瓶和20支兔尾巴草,20支兔尾巴草");
        map.put("p_num","8,8,8");
        map.put("p_postFee",0);
        map.put("p_payment",999.9);
        map.put("p_paymentType","2");
        map.put("p_orderId","092903468886031371");
        map.put("p_shopper","羊羊羊");
        map.put("p_address",11);
        orderMapper.insertOrderAndOrderDetail(map);
        String state = (String) map.get("p_success");
        System.out.println(state);
    }
}
