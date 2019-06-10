package com.ToolMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
    public String GetTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
 //       System.out.println(df.format(new Date()));  // new Date()为获取当前系统时间
        String time = df.format(new Date());
        return time;
    }

    public String ChageTimeRule(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = df.format(date);
        return time;
    }
}
