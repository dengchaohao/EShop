package cn.edu.ncu.service;

import cn.edu.ncu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15.
 * @Description: mybatis-study-01
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public interface UserService {
    int updateHeadPicUrlById(User user, String headPicUrl);
    User queryUserByUsername(@Param("username") String username);
    Integer insertUser(User user);
    boolean hasUserByUsername(User user);
    List<User> findUserByMail(String mail);
    boolean userModify(User user);
}
