package com.service;

import com.ToolMethod.GetTime;
import com.base.ServiceContain;
import com.pojo.User;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created on 2018.06.11.
 */
@Service
public class UserService extends ServiceContain {

    /****************************登陆注册 开始*************************************/
    //查询 (登陆逻辑)
    public SiteResponse search(User user) {
        long id = 0;
        loginUser = 0; //初始化状态
        List<User> userList = userMapper.search(user);
        System.out.println("是否查询到?:" + userList.size());

        if (userList.size() == 0) { //长度为0表示 数据库里面没有记录
            return returnResponse(userList, "登陆失败,用户参数错误", false);
        } else {
            for (User i : userList) {
                //从User对象里面获取字段
                //System.out.println("用户名是:" + i.getUsername() + "密码是:" + i.getPassword() + "用户真实姓名是:" + i.getName());
                loginUser = i.getId(); //(因为I是User类型的所以可以直接调用set\get方法)把用户id赋值给 登陆状态
                user.setId(loginUser);
                user.setState(true);

                HttpSession userSession = request.getSession();
                userSession.setAttribute("userSession", user);

                userMapper.changeState(user);
                loginIdList.add(loginUser);
                System.out.println("有内容?:" + loginIdList.size());

                id = i.getId(); //将当前登陆的id返回给前端
            }
            System.out.println("目前登陆的用户id是:" + loginUser);
            for (Long loginId : loginIdList) {
                System.out.print("已登陆的用户有:" + loginId + "号");
                System.out.print(",");
            }
            return returnResponse(id, "登陆成功", true);
        }
    }

    //查询user表中的所有记录
    public SiteResponse searchAllUser() {
        List<User> allUser = userMapper.searchAllUser();
        System.out.println("查询到有" + allUser.size() + "条user记录");
        return returnResponse(allUser, "查询所有记录成功", true);
    }

    //增  (注册逻辑)
    public SiteResponse insert(User user) {
//        user.setUsername("19191919");
//        user.setPassword("19831983");
//        user.setName("周杰伦");
        String create_time = new GetTime().GetTime();
        List<User> tt = userMapper.QueriesAlreadyExist(user);
        System.out.println(tt.size()); //打印查询到的List长度 , 为0表示user表没有记录,为1表示有记录
        if (tt.size() == 0) {
            //用户名密码必须8位到10位
            if (user.getUsername().matches("^[0-9]([0-9]{7,9})$") && user.getPassword().matches("^[0-9]([0-9]{7,9})$")) {
                userMapper.insert(user, create_time);
                return returnResponse("1", "注册成功", true);
            } else {
                return returnResponse("1", "注册失败,用户的输入不规范", true);
            }
        }
        return returnResponse("1", "注册失败,用户已存在", true);
    }

    //注销当前登陆的用户
    public SiteResponse rebootOneUser() {
        HttpSession session1 = request.getSession();
        User user1 = (User) session1.getAttribute("userSession");
        userMapper.rebootOneUser(user1);
        session1.removeAttribute("userSession");    //清除session1里面的缓存
        return returnResponse("off", "用户已注销", true);
    }

    //注销所有
    public SiteResponse rebootAll() {
        userMapper.rebootAll();
        return returnResponse("All of them reboot", "已经注销所有用户", true);
    }


    /****************************登陆注册 结束*************************************/

//    //删
//    public SiteResponse delete(User user) {
//        int myid = 1;
//        user.setId((long) myid); //因为是lang类型参数我们需要强制类型转化
//        arr[0] = myid;
//        //userMapper.delete(user,2);
//        userMapper.delete(user);
//        return returnResponse("删除了id为1的记录", "删除成功", true);
//    }
//
//    //修改
//    public SiteResponse update(User user) {
//        userMapper.update(user);
//        return returnResponse("修改了id为2的username", "修改成功", true);
//    }
}


/**
 * 编辑区
 * String s1 = "A";
 * String s2 = String.valueOf(++a);
 * String key = s1 + s2;
 * IDcard.put(key,i.getId());
 * demandsService.IDcard = key;
 * user.setIDcard(key);
 * 编辑区
 **/