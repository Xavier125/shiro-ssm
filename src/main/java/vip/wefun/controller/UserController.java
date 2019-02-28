package vip.wefun.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.wefun.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    private UserService userServiceImpl;

    @GetMapping(value = {"/", "/index"})
    public String index() {
        System.out.println( "index" );
        return "menu";
    }

    @RequestMapping("/login")
    public String Login(HttpServletRequest request, Model model) {
        System.out.println( "================Login======================" );
        String exceptionClassName = (String) request.getAttribute( "shiroLoginFailure" );
        System.out.println( "exceptionClassName:" + exceptionClassName );
        String error = null;
        if (UnknownAccountException.class.getName().equals( exceptionClassName )) {
            error = "用户名/密码错误";
        } else if (IncorrectCredentialsException.class.getName().equals( exceptionClassName )) {
            error = "用户名/密码错误";
        } else if (exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute( "error", error );
        return "redirect:login.jsp";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        return "redirect:login.jsp";
    }
}
