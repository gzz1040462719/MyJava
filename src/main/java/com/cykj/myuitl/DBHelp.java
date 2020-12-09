package com.cykj.myuitl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelp {
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    //执行查询
    public static ResultSet getResultSet(String sql, Object[] objects) {
        ConnectPool connectPool = ConnectPool.getInstance();
        Connection connection = connectPool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (objects != null) {
                for (int i = 0; i < objects.length; i++) {
                    preparedStatement.setObject(i + 1, objects[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectPool.setConnection(connection);
        }
        return resultSet;
    }

    //执行修改
    public static int getResultSetUpdate(String sql, Object[] objects) {
        int number = 0;
        ConnectPool connectPool = ConnectPool.getInstance();
        Connection connection = connectPool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            number = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectPool.setConnection(connection);
        }
        return number;
    }

    //查询总页数
    public static int getTotal(String sql){
        int j=0;
        ConnectPool connectPool = ConnectPool.getInstance();
        Connection connection = connectPool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                j=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectPool.setConnection(connection);
            close();
        }
        return j;
    }

    //释放资源
    public static void close() {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    //执行查询
//    public static<T> Object getResultSet(String sql,Object[] objects,Class<T> aClass){
//        ConnectPool connectPool = ConnectPool.getInstance();
//        Connection connection = connectPool.getConnection();
//        Object o=null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            for (int i = 0; i < objects.length; i++) {
//                preparedStatement.setObject(i+1,objects[i]);
//            }
//            resultSet= preparedStatement.executeQuery();
//
//            if (resultSet.next()){
////                Class<?> aClass = Class.forName(calssName);
//                Constructor<?> constructor = aClass.getConstructor();
//                while (resultSet.next()){
//                    //获取所有字段长度的数组
//                    Object[] Parameter=new Object[aClass.getDeclaredFields().length];
//                    //获取所有属性
//                    Field[] fields = aClass.getDeclaredFields();
//                    for (int i = 0; i < fields.length; i++) {
//                        fields[i].setAccessible(true);
//                        //获取所有属性名
//                        String name = fields[i].getName();
//                        Parameter[i]=name;
//                        System.out.println(Parameter[i]);
//                    }
//                    if (Parameter[0]!=null){
//                        o = constructor.newInstance(Parameter);
//                    }
//                }
//            }
//        } catch (SQLException | NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } finally {
//            connectPool.setConnection(connection);
//        }
//        return o;
//    }
}
