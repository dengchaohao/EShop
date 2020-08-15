package cn.edu.ncu.dao;

import cn.edu.ncu.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15
 * @Description: mybatis-study-01
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public interface UserDAO {
    public User queryUserByUsername(@Param("username") String username);
    public Integer insertUser(User user);
}
