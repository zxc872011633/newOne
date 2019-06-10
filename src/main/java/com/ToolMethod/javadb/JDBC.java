package com.ToolMethod.javadb;

import java.sql.*;

public class JDBC {
    String mydriver = "com.mysql.jdbc.Driver";
    String mysource = "jdbc:mysql://localhost:3306/springboot"; // book是数据库名字
    ResultSet rs = null; // 定义 结果集
    Statement st = null; // 定义 语句
    Connection con = null;

    // 构造方法加载驱动
    public JDBC() {
        try {
            Class.forName(mydriver); // 加载驱动
        } catch (java.lang.ClassNotFoundException e) { // 捕获 找不到 异常
            e.getStackTrace();
        }
    }

    // 查询的方法
    public ResultSet myQuery(String mysql) {
        try {
            con = DriverManager.getConnection(mysource, "root", "root"); // 操作数据库之前，需要输入连接数据库的用户名和密码
            // 都是
            // “root”
            st = con.createStatement(); // 创建语句
            rs = st.executeQuery(mysql); // 执行查询

        } catch (SQLException e) {

            e.getStackTrace();
        }
        return rs;

    }
    // 数据的增、删、改方法
    public int myUpdate(String mysql) {

        int result = 0;

        try {
            con = DriverManager.getConnection(mysource, "root", "root");
            st = con.createStatement();
            result = st.executeUpdate(mysql);
        } catch (SQLException e) {

            e.getStackTrace();
        }
        return result;
    }

}
