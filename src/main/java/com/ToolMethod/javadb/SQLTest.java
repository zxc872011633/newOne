package com.ToolMethod.javadb;

import java.sql.ResultSet;

import static com.ToolMethod.TimeLogic.compare_date;

public class SQLTest {
    static String starttime;
    static String endtime;

    public static void main(String args[]) {
//
//        JDBC jdbc = new JDBC();
//        ResultSet rs =  jdbc.myQuery("select * from user");
//        try {
//            while(rs.next()) {
//                System.out.println( rs.getString("name"));
//            }
//        }catch (Exception e) {
//            e.getStackTrace();
//        }


        JDBC jdbc = new JDBC();
        ResultSet rs1 = jdbc.myQuery("select * from user where name = '张三' ");
        ResultSet rs2 = jdbc.myQuery("select * from user where name = '李四' ");
//
//        try {
//            while (rs1.next()) {
//                System.out.println(rs1.getString( "create_time"));
//            }
//            System.out.println("********************************************************");
//            while (rs2.next()) {
//                System.out.println(rs2.getString("create_time"));
//            }
//
//
//        } catch (Exception e) {
//            e.getStackTrace();
//        }

        try {
            while (rs1.next()) {
               starttime = rs1.getString("create_time");
            }

            while (rs2.next()) {
                endtime = rs2.getString("create_time");
            }
        } catch (Exception e) {
            System.out.println("获取异常");
        }
        System.out.println(compare_date(starttime,endtime));
        System.out.println("张三时间:" + starttime);
        System.out.println("李四时间:" + endtime);
    }

//查询总条数 (来自DemandsServise 查询所有的 剪贴)
//    JDBC jdbc = new JDBC();
//    ResultSet allDemands = jdbc.myQuery("select count(id) from demands ");
//        System.out.println(allDemands);
//        try {
//        while(allDemands.next()) {
//
//            System.out.println("总页数:" + allDemands.getString("count(id)"));
//        }
//    }catch (Exception e) {
//        e.getStackTrace();
//    }


}
