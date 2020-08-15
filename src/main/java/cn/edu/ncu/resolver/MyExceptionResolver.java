package cn.edu.ncu.resolver;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15.
 * @Description: mybatis-study-01
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println(e.getClass());
        e.printStackTrace(); // 开发时必须
        ModelAndView mv = new ModelAndView();
        if (e instanceof IncorrectCredentialsException || e instanceof UnknownAccountException){
            // 跳转登录页面，重新登录
            mv.setViewName("redirect:/user/login");         // 重定向时，重新给浏览器发一个请求
        }else if(e instanceof UnauthorizedException){       // 权限不足 角色不足
            mv.setViewName("redirect:/user/perms/error");
        }else if (e instanceof UnauthenticatedException){   // 没有登录，没有合法身份
            mv.setViewName("redirect:/user/login");
        }
        return mv;
    }
}
