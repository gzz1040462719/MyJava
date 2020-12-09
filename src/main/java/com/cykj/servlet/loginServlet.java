package com.cykj.servlet;

import com.cykj.bean.LayuiReplay;
import com.cykj.bean.Parameter;
import com.cykj.bean.User;
import com.cykj.dao.UserDao;
import com.cykj.dao.impl.UserDaoimpl;
import com.cykj.myuitl.ObjectFactory;
import com.cykj.service.UserService;
import com.cykj.service.impl.UserServiceimpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@WebServlet("/loginServlet")
public class loginServlet extends BaseServlet {
    UserDao userDao = (UserDao) ObjectFactory.newInstance(UserDaoimpl.class);
    UserService userService = (UserService) ObjectFactory.newInstance(UserServiceimpl.class);
    //登录
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        User user = userDao.login(account, password);
        if (user!=null){
            resp.getWriter().write("登录成功");
            req.getSession().setAttribute("user",user);
        }else {
            resp.getWriter().write("登录失败");
        }
    }


    //主界面
    public String mianInterface(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user",user);
        return "pages/main.jsp";
    }


    //注册
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
         User user=new User();
        user.setUserAccount(req.getParameter("userAccount"));
        user.setUserPassword(req.getParameter("userPassword"));
        user.setUserName(req.getParameter("userName"));
        user.setEmail(req.getParameter("email"));
        user.setMobile(req.getParameter("mobile"));
        user.setSex(req.getParameter("sex"));
        user.setIdNumber(req.getParameter("idNumber"));
        int i = userDao.addUser(user);
        if (i>0){
            resp.getWriter().write("注册成功");
        }else {
            resp.getWriter().write("注册失败");
        }
    }

    //用户列表
    public void userList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int count=0;//总条数
        int currentPage=1;//当前页数
        int size=5;//每页显示条数
        String page=req.getParameter("page");//当选择了分页之后，会自动加上page和limit的上传参数
        String limit=req.getParameter("limit");//page表示当前页，limit表示每页显示条数
        if(page!=null&&!"".equals(page)){
            currentPage=Integer.parseInt(page);
        }
        if(limit!=null&&!"".equals(limit)){
            size=Integer.parseInt(limit);
        }
        HashMap<String, Object> map = new HashMap<>();
        String stateTime=req.getParameter("stateTime");
        String entTime=req.getParameter("entTime");
        String userName=req.getParameter("userName");

        if(stateTime!=null&&!"".equals(stateTime)){
            map.put("stateTime",stateTime);
            req.setAttribute("stateTime",stateTime);
        }
        if(entTime!=null&&!"".equals(entTime)){
            map.put("entTime",entTime);
            req.setAttribute("entTime",entTime);
        }
        if(userName!=null&&!"".equals(userName)){
            map.put("userName",userName);
            req.setAttribute("userName",userName);
        }
        List<User> list = userDao.userList(map, currentPage, size);
        System.out.println(list.size());
        count=userDao.UserTotal(map);
        LayuiReplay<User> layuiReplay = new LayuiReplay<>(0, "", count, list);
        resp.getWriter().write(layuiReplay.toJson());
    }

    //改变用户状态
    public void userState(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String userId = req.getParameter("userId");
        String userState = req.getParameter("userState");
        HashMap<String, Object> map = new HashMap<>();
        map.put("userState",new BigDecimal(userState));
        int i = userDao.updateUser(map, new BigDecimal(userId));
        if (i>0){
            resp.getWriter().write("修改成功");
        }else {
            resp.getWriter().write("修改失败");
        }
    }

//    //初始化访问修改积分奖励页面
//    public void initScorePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        Parameter parameter = userService.initScorePage();
//        Gson gson = new Gson();
//        resp.getWriter().write(gson.toJson(parameter));
//    }
//    //修改积分奖励
//    public void updateScore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        String score = req.getParameter("score");
//        int i = userService.updateScore(score);
//        if (i>0){
//            resp.getWriter().write("修改成功");
//        }else {
//            resp.getWriter().write("修改失败");
//        }
//    }


}
