package cn.edu.ncu.service;

import cn.edu.ncu.constant.Constant;
import cn.edu.ncu.dao.UserMapper;
import cn.edu.ncu.pojo.User;
import cn.edu.ncu.pojo.UserExample;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
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
    private UserMapper userMapper;

    @Override
    public int updateHeadPicUrlById(User user, String headPicUrl){
        UserExample example = new UserExample();
        UserExample.Criteria cri = example.createCriteria();
        cri.andUsernameEqualTo(user.getUsername());
        user.setHeadPic(headPicUrl);
        return userMapper.updateByExampleSelective(user,example);
    }

    @Override
    public List<User> findUserByMail(String mail){
        UserExample example=new UserExample();
        UserExample.Criteria cri = example.createCriteria();
        cri.andEmailEqualTo(mail);
        return userMapper.selectByExample(example);
    }

    public boolean userModify(User user) {
        UserExample example=new UserExample();
        UserExample.Criteria cri = example.createCriteria();
        cri.andUsernameEqualTo(user.getUsername());
        if(userMapper.updateByExampleSelective(user, example)>0){
            return true;
        }
        return false;
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserByUsername(String username) {
        return userMapper.selectByPrimaryKey(username);
    }

    @Override
    public Integer insertUser(User user) {
        // 加密
        String salt = UUID.randomUUID().toString();
        String s = new Sha256Hash(user.getPassword(), salt, Constant.INTERCOUNT).toBase64();
        // 设置密文
        user.setPassword(s);
        // 设置盐
        user.setSalt(salt);
        return userMapper.insertUser(user);
    }

    @Override
    public boolean hasUserByUsername(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria cri = example.createCriteria();
        cri.andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0) {
            return true;
        }
        return false;
    }
}
