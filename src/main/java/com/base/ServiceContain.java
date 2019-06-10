package com.base;

import com.UploadAndDownLoad.ForUpLoad;
import com.pojo.other.SiteResponse;
import com.service.DemandsService;
import com.service.TaskServise;
import com.service.UploadService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by li on 2017/11/27.
 */
public class ServiceContain extends MapperContain {
    //如果话红线,请检查你的servise文件是否写了@Servise注释

    //用户
    @Autowired
    public UserService userService;
    @Autowired
    public DemandsService demandsService;
    @Autowired
    public TaskServise taskServise;
    @Autowired
    public UploadService uploadService;
    @Autowired
    public HttpSession session;
    @Autowired
    public HttpServletRequest request;
    @Autowired
    public ApplicationContext applicationContext;

    public static long loginUser;   //储存登陆用户的id
    public static Set<Long> loginIdList = new HashSet<Long>();  //储存已登陆的用户id集合
//    public static Map IDcard = new HashMap(); // 身份牌配上id


    public  static  ForUpLoad forUpLoad = new ForUpLoad(); //创建文件操作功能的实现类对象
    //定义一个存放id的数组
    public static int arr[] = new int[2000];  //为了不让每次访问重新实例化一个数组对象,用static修饰(达到简单存储的目的)
    public static String s1;  //实现连接变量的字符串
    //定义一个字符串数组
    public static String fileinfo[] = new String[2000];


    //返回前端数据
    public SiteResponse returnResponse(Object data, String msg, Boolean state) {
        SiteResponse siteResponse = new SiteResponse();
        siteResponse.map.put("data", data);
        siteResponse.setMsg(msg);
        siteResponse.setState(state);
        return siteResponse;
    }
}
