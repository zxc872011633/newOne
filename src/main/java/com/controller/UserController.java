package com.controller;

import com.base.ServiceContain;
import com.pojo.User;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// @RequestMapping("/api/user") 和方法的value写在请求的路径,服务器localhost 端口号在target里面找(默认2019)  方法对应method 的get,post,put
//@RequestParam(value = "userName", required = false) String username ,
@Controller
@RequestMapping("/api/user")
public class UserController extends ServiceContain {
    //登陆(注意 @RequestBody 不能用 get请求)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse search(@RequestBody User user) {
//        user.setUsername("123456789");
//        user.setPassword("123456789");
        user.getUsername();
        user.getPassword();
        return userService.search(user);
    }

    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse insert(@RequestBody User user) {
        return userService.insert(user);
    }

    //注销当前登陆的用户
    @RequestMapping(value = "/reboot", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse reboot() {
        return userService.rebootOneUser();
    }

    //让所有用户下线
    @RequestMapping(value = "/rebootAll", method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse rebootAll() {  //全局操作无需参数传递
        return userService.rebootAll();
    }

    //查询所有user记录
    @RequestMapping(value = "/findAllUser", method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse searchAllUser() {
        return userService.searchAllUser();
    }
}
//    //删除数据
//    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
//    @ResponseBody
//    public SiteResponse delete(@ModelAttribute User user) {
//        return userService.delete(user);
//    }
//
//    //修改数据
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @ResponseBody
//    public SiteResponse update(@ModelAttribute User user) {
//        return userService.update(user);
//    }


//    //写入删除日志
//    @RequestMapping(value = "/insertDeleteLog", method = RequestMethod.POST)
//    @ResponseBody
//    public SiteResponse insertIntoDatabase(@ModelAttribute User user) {
//        return userService.insertIntoDatabase(user);
//    }