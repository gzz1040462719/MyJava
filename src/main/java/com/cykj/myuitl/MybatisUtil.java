package com.cykj.myuitl;

import com.cykj.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Mybatis工具类
public class MybatisUtil {
    //配置文件地址
    private static final String CONFIG_PATH = "mybatis-config.xml";
    //SqlSessionFactory工厂对象
    private SqlSessionFactory sessionFactory = null;
    private SqlSession session = null;
    private static MybatisUtil mybatisUtil = null;


    //初始SqlSessionFactory工厂对象单例
    private MybatisUtil() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(CONFIG_PATH);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //获取实例
    public static synchronized MybatisUtil getInstance() {
        if (null == mybatisUtil) {
            synchronized (MybatisUtil.class) {
                mybatisUtil = new MybatisUtil();
            }

        }
        return mybatisUtil;
    }

    //获取SqlSession
    public synchronized SqlSession getSession() {
        return  sessionFactory.openSession(false);
    }

    //关闭session
    public synchronized void close(SqlSession session) {
        session.commit();
        session.close();
    }
}
