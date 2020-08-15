package cn.edu.ncu.test;

import cn.edu.ncu.dao.RoleDAO;
import cn.edu.ncu.dao.UserDAO;
import cn.edu.ncu.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        RoleDAO RoleDAO = context.getBean("roleDAO", RoleDAO.class);
        Set<String> roles = RoleDAO.queryAllRolenameByUsername("songsong");
        for (String role : roles) {
            System.out.println(role);
        }
    }
}
