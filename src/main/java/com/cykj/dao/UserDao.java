package com.cykj.dao;

import com.cykj.bean.Parameter;
import com.cykj.bean.User;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface UserDao {

    //登录
    public User login(String account, String password);

    //注册
    public int addUser(User user);

    //用户列表
    public List<User> userList(HashMap<String, Object> condition, int curPage, int pageSize);

    //总页数
    public int UserTotal(HashMap<String, Object> condition);

    //修改用户
    public int updateUser(HashMap<String, Object> condition, BigDecimal userId);


}
