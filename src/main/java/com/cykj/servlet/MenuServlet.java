package com.cykj.servlet;

import com.cykj.bean.Menu;
import com.cykj.bean.User;
import com.cykj.myuitl.ObjectFactory;
import com.cykj.service.MenuService;
import com.cykj.service.UserService;
import com.cykj.service.impl.MenuServiceImpl;
import com.cykj.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/MenuServlet")
public class MenuServlet  extends BaseServlet  {

    MenuService menuService = (MenuService) ObjectFactory.newInstance(MenuServiceImpl.class);
    //初始化角色菜单
//    public void initMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User user = (User) req.getSession().getAttribute("user");
//        HashMap<String, List<Menu>> map = menuService.initMenu(user.getRole());
//        Gson gson=new Gson();
//        String s = gson.toJson(map);
//        resp.getWriter().write(s);
//        System.out.println(s);
//    }

}
