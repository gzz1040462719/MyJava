package com.cykj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取客户端请求方式名
        String methodName=req.getParameter("methodName");
        //获取当前调用方法类
        Class clazz=this.getClass();
        try {
            //通过方法名获取方法对象
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            try {
                //执行方法
                String path =(String) method.invoke(this, req, resp);
                if (path!=null && !path.trim().equals("")){
                    System.out.println("跳转的界面："+path);
                    req.getRequestDispatcher(path).forward(req,resp);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                System.out.println(methodName);
                e.printStackTrace();
            }


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
