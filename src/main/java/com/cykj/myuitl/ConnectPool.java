package com.cykj.myuitl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectPool {
    public static ConnectPool connectPool=null;
    public static List<Connection> list=new ArrayList<>();

    static {
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/java1";
        try {
            Class.forName(driver);
            for (int i = 0; i < 50; i++) {
                Connection conn= DriverManager.getConnection(url,"root","123456");
                list.add(conn);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private ConnectPool(){
    }


    //初始化连接池
    public synchronized static ConnectPool getInstance(){
        if (connectPool==null){
            connectPool=new ConnectPool();
        }
        return connectPool;
    }

    //获取连接对象
    public Connection getConnection(){
        System.out.println("剩余连接对象"+list.size());
        if (list.size()>0){
            return list.remove(0);
        }
        return null;
    }

    //归还连接对象
    public void setConnection(Connection connection){
        if (connection!=null){
            list.add(connection);
        }
    }

}
