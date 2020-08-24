package cn.edu.ncu.test;

import cn.edu.ncu.dao.OrderDetailMapper;
import cn.edu.ncu.dao.OrderMapper;
import cn.edu.ncu.dao.RoleDAO;
import cn.edu.ncu.dto.GoodsAndOrderDetailDTO;
import cn.edu.ncu.dto.OrderAndAddressDTO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Set;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-22.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public class DTOTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //UserDAO userDAO = context.getBean("userDAO", UserDAO.class);
        //User user = new User(null, "new_user", "123",null);
        //userDAO.insertUser(user);
        OrderMapper orderMapper = context.getBean("orderMapper", OrderMapper.class);
        OrderAndAddressDTO orderAndAddressDTO = orderMapper.queryOrderAndAddressByOrderId("545830385192170114");
        System.out.println(orderAndAddressDTO);

        OrderDetailMapper orderDetailMapperMapper = context.getBean("orderDetailMapper", OrderDetailMapper.class);
        List<GoodsAndOrderDetailDTO> goodsAndOrderDetailDTOs = orderDetailMapperMapper.queryGoodsAndOrderDetailByOrderId("545830385192170114");
        for (GoodsAndOrderDetailDTO goodsAndOrderDetailDTO : goodsAndOrderDetailDTOs) {
            System.out.println(goodsAndOrderDetailDTO);
        }

        GoodsAndOrderDetailDTO goodsAndOrderDetailDTO = orderDetailMapperMapper.queryGoodsAndOrderDetailById(1);
        System.out.println("****  " + goodsAndOrderDetailDTO);
    }
}
