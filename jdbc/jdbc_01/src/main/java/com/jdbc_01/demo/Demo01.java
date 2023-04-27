package com.jdbc_01.demo;

import java.sql.*;
import java.util.Enumeration;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/3/11 21:54
 */
public class Demo01 {
    public static void main(String[] args) {
        // 1、Statement和PrepareStatement的区别

        String driverName = "org.postgresql.Driver";
        String url = "jdbc:postgresql://192.168.74.133:5432/openatc";
        String userName = "postgres";
        String password = "123456";
        // 1、注册驱动
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 2、获取数据库连接对象
        Connection connection = null;
        try {
            Connection connection2 = DriverManager.getConnection(url);
            Connection connection1 = DriverManager.getConnection(url, userName, password);
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = drivers.nextElement();
            }
            connection = DriverManager.getConnection(url, userName, password);
            // 3、获取sql操作对象
            Statement statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


        // 4、执行sql语句

        // 5、处理结果集

        // 6、关闭连接


    }
}
