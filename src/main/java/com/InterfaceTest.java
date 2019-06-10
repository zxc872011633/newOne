package com;

import com.AOP.FileOperatingInterceptor;
import com.ToolMethod.GetTheTileName;
import com.ToolMethod.GetTime;
import com.UploadAndDownLoad.ForUpLoad;
import com.base.ServiceContain;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InterfaceTest extends ServiceContain {
    public static void main(String args[]) throws IOException {

        /*demo1 测试 创建文件接口方法*/

//        String src = "D:\\test\\test.exe";
//        ForUpLoad forUpLoad = new ForUpLoad();
//        forUpLoad.CreatFile(src);

//        String src = "D:\\test\\test.exe";
//        ApplicationContext aplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ForUpLoad interceptorObject = (ForUpLoad)  aplicationContext.getBean("interceptorObject");
//        interceptorObject.CreatFile(src);

        /*demo2 测试 上传(单个)文件接口方法(注意方法不要调用错误)*/
//       String src1 = "D:\\test\\test.txt";
//       String src2 = "D:\\test.txt";
//       ForUpLoad forUpLoad = new ForUpLoad();
//       forUpLoad.UploadFile(src1,src2);

//       String src1 = "D:\\test\\test.txt";
//       String src2 = "D:\\test.txt";
//        ApplicationContext aplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ForUpLoad interceptorObject = (ForUpLoad)  aplicationContext.getBean("interceptorObject");
//        interceptorObject.UploadFile(src1,src2);


        /*demo3 测试 上传(文件夹)接口方法*/
//        String src1 = "E:\\down\\speedpan";
//        String src2 = "D:\\dest\\";
//        ForUpLoad forUpLoad = new ForUpLoad();
//        forUpLoad.UploadFiles(src1,src2);


//        String src1 = "E:\\down\\speedpan";
//        String src2 = "D:\\dest\\";
//        ApplicationContext aplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ForUpLoad interceptorObject = (ForUpLoad)  aplicationContext.getBean("interceptorObject");
//        interceptorObject.UploadFiles(src1,src2);


        //显示当前时间
        //创建一个日期对象
//        Date d=new Date();
//        System.out.println(d);

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间


//      String showtime = new GetTime().GetTime();
//      System.out.println("当前时间:" + showtime);
  //          System.out.println(fileinfo[0]);
    }
}
