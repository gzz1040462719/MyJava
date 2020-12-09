package com.cykj.bean;

import com.cykj.mapper.UserMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;

public class DemoRun {
    public static void main(String[] args) {
//            User user = new User();
////        user.setId(3);
//            SqlSession session = MybatisUtil.getInstance().getSession();
//            UserMapper userMapper = session.getMapper(UserMapper.class);
//            userMapper.deleteUserById(user);
//            session.commit();
//            session.close();


        //把配置文件读取到IO流
//        try {
//            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            SqlSession session = sessionFactory.openSession(false);//打开事务，取消自动提交
//            UserMapper userMapper = session.getMapper(UserMapper.class);
//            User user = new User();
//            user.setId(1);
//            user.setUsername("admin");
//            user.setPassword("admin");
//            userMapper.updateUser(user);
//            session.commit();
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
