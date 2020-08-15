package cn.edu.ncu.realm;

import cn.edu.ncu.pojo.User;
import cn.edu.ncu.service.PermissionService;
import cn.edu.ncu.service.RoleService;
import cn.edu.ncu.service.UserService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15.
 * @Description: 自定义Realm
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Setter
public class MyRealm extends AuthorizingRealm {

    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;

    /**
     * @Author: YIJUN ZHAI
     * @Data: 2020/7/20 15:13
     * @Description: 作用：查询权限信息，包括权限和角色，封装返回即可，不用任何比对
     *  何时触发： /user/query = roles["admin"] /user/insert = perms["user:insert"] <shiro:hasRole <shiro"hasPermission
     *  查询方式：通过用户名查询，查询该用户的 权限/角色信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取当前用户的用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        // 查询当前用户的所有 权限信息：RoleService:public List<String:Rolename> queryAllRolesByUsername(String username)
                             //     PermissionService:public List<String:Permissionname> queryAllPermissionsByUsername(String Username)
        //RoleService roleService = ContextLoader.getCurrentWebApplicationContext().getBean("roleServiceImpl", RoleService.class);
        //PermissionService permissionService = ContextLoader.getCurrentWebApplicationContext().getBean("permissionServiceImpl", PermissionService.class);
        // 查询用户当前的权限信息
        Set<String> roles = roleService.queryAllRolenameByUsername(username);
        Set<String> perms = permissionService.queryALLPermissionsByUsername(username);
        // 将查询的信息 封装
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        simpleAuthorizationInfo.setStringPermissions(perms);
        return simpleAuthorizationInfo;
    }
    /**
     * @Author: YIJUN ZHAI
     * @Data: 2020/7/20 15:13
     * @Description: 作用：查询身份信息,并返回即可，不用任何比对
     * 何时触发：subject.login(token);
     * 查询方式：通过用户名查询用户信息。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户登录时发送来的用户名
        String username = (String) authenticationToken.getPrincipal();
        // 查询用户信息：UserService:public User queryUserByUsername(String username)
        //UserService userService = ContextLoader.getCurrentWebApplicationContext().getBean("userServiceImpl", UserService.class);
        // 查询用户信息
        User user = userService.queryUserByUsername(username);
        //判断用户信息是否为null
        if(user == null){ // 不存在用户名
            return null; // 在后续流程中会抛出异常 UnknowAccountException
        }

        // 将用户信息封装在 AuthenticationInfo 中
        /*return new SimpleAuthenticationInfo(user.getUsername(), // 数据库中的用户名
                user.getPassword(), // 数据库中的密码
                this.getName()); // realm的标识*/

        // 将用户信息封装在 AuthenticationInfo 中
        return new SimpleAuthenticationInfo(user.getUsername(), // 数据库中的用户名
                user.getPassword(), // 数据库中的密码
                ByteSource.Util.bytes(user.getSalt()), // 数据库中的盐
                this.getName());    // realm的标识
    }
}
