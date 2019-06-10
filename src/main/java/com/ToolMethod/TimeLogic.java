package com.ToolMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeLogic {

    public static int compare_date(String startTime, String endTime) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            //先把String 转换成日期类型
            Date dt1 = df.parse(startTime);
            Date dt2 = df.parse(endTime);

            //比较时间的前后
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("startTime 在endTime前,异常情况");
                return -1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("startTime在endTime后,正常情况");
                return 1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
