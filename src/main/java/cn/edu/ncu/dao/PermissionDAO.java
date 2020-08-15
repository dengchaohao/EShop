package cn.edu.ncu.dao;


import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15
 * @Description: mybatis-study-01
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public interface PermissionDAO {
    public Set<String> queryALLPermissionsByUsername(@Param("username") String usernmame);
}
