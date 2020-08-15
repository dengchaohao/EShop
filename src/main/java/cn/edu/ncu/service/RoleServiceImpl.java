package cn.edu.ncu.service;

import cn.edu.ncu.dao.RoleDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15.
 * @Description: mybatis-study-01
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDAO roleDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    public Set<String> queryAllRolenameByUsername(String username) {
        return roleDAO.queryAllRolenameByUsername(username);
    }
}
