package vip.wefun.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.wefun.pojo.Menu;
import vip.wefun.pojo.User;
import vip.wefun.service.MenuService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MenuController {

    @Resource
    MenuService menuServiceImpl;

    @RequestMapping("show")
    @RequiresPermissions("menu:list")
    public String show(HttpSession session) {
        Object principle = SecurityUtils.getSubject().getPrincipal();
        if (principle == null) {
            return null;
        } else {
            User user = (User) principle;
            System.out.println( "user:" );
            System.out.println( user);
            List<Menu> menuList = menuServiceImpl.show( 0 );
            user.setMenuList( menuList );
            session.setAttribute( "user", user );
            return "menu";
        }
    }


//    @RequestMapping("show")
//    @ResponseBody
//    @RequiresPermissions( "menu:list" )
//    public List<Menu> show(HttpSession session) {
//        Object object = session.getAttribute("user");
//        System.out.println(session.getAttribute("user"));
//        if(object == null) {
//            return null;
//        }else {
//            return ((User)session.getAttribute("user")).getMenuList();
//        }
//        System.out.println("show");
//        System.out.println(menuServiceImpl.show( 0 ));
//        return menuServiceImpl.show( 0 );
//    }
}
