package cn.edu.ncu.service;

import cn.edu.ncu.constant.MyConstant;
import cn.edu.ncu.dao.UserDAO;
import cn.edu.ncu.pojo.User;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15.
 * @Description: mybatis-study-01
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserByUsername(String username) {
        return userDAO.queryUserByUsername(username);
    }

    @Override
    public Integer insertUser(User user) {
        // 加密
        String salt = UUID.randomUUID().toString();
        String s = new Sha256Hash(user.getPassword(), salt, MyConstant.INTERCOUNT).toBase64();
        // 设置密文
        user.setPassword(s);
        // 设置盐
        user.setSalt(salt);
        return userDAO.insertUser(user);
    }
}
