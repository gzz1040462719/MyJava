package com.cykj.dao.impl;

import com.cykj.bean.Parameter;
import com.cykj.bean.User;
import com.cykj.dao.UserDao;
import com.cykj.mapper.ParameterMapper;
import com.cykj.mapper.UserMapper;
import com.cykj.myuitl.DBHelp;
import com.cykj.myuitl.MyTool;
import com.cykj.myuitl.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDaoimpl implements UserDao {

    //登录
    @Override
    public User login(String account, String password) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.login(account, password);
        MybatisUtil.getInstance().close(session);
        return user;
    }

    //注册
    @Override
    public int addUser(User user) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.addUser(user);
        MybatisUtil.getInstance().close(session);
        return i;
    }
    //用户列表
    @Override
        public List<User> userList(HashMap<String, Object> condition,int curPage,int pageSize) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        condition.put("startPage",(curPage - 1) * pageSize);
        condition.put("endPage",(curPage *pageSize));
        List<User> all = mapper.findAll(condition);
        MybatisUtil.getInstance().close(session);
        return all;
    }

    //总页数
    @Override
    public int UserTotal(HashMap<String, Object> condition) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.UserTotal(condition);
        MybatisUtil.getInstance().close(session);
        return i;
    }

    //修改用户
    @Override
    public int updateUser(HashMap<String, Object> condition, BigDecimal userId) {
        User user=new User();
        //增加修改状态
        if (condition.containsKey("userState")){
            BigDecimal userState = (BigDecimal) condition.get("userState");
            user.setUserState(userState);
        }
        user.setUserId(userId);
        SqlSession session = MybatisUtil.getInstance().getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.updateUser(user);
        MybatisUtil.getInstance().close(session);
        return i;
    }

}
