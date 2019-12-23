package com.util;

import java.sql.*;

public class DBconn {
    static String url = "jdbc:mysql://localhost:3306/test?&useSSL=false&serverTimezone=UTC";
    static String username = "root";
    static String password = "admin";
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    public static void init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            System.out.println("初始化失败");
            e.printStackTrace();
        }
    }
    public static int addUpdDel(String sql){
        int i = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
                    i = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("增删改异常");
            e.printStackTrace();
        }
        return i;
    }
    public static ResultSet selectSql(String sql){
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("sql查询异常");
            e.printStackTrace();
        }
        return rs;
    }
    public static void closeConn(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("数据库关闭异常");
            e.printStackTrace();
        }
    }

}
