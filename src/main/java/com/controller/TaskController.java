package com.controller;


import com.base.ServiceContain;
import com.pojo.Task;
import com.pojo.other.SiteResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/task")
public class TaskController extends ServiceContain {

    //分配任务 (传递 需求id 和指定人的id)
    @RequestMapping(value = "/assTask", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse assDemands(@RequestBody Task task) {
        return taskServise.assTask(task);
    }

    //完成任务 (传入任务的id)
    @RequestMapping(value = "/finishTask", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse finishTask(@RequestBody Task task) {
//        task.setId(27);
        return taskServise.finishTask(task);
    }

    //删除(单个)任务 (传递任务表中要删除的id)
    @RequestMapping(value = "/delTask", method = RequestMethod.DELETE)
    @ResponseBody
    public SiteResponse delTask(@RequestBody Task task) {
//        task.setId(31);
        return taskServise.delTask(task);
    }

    //修改任务(传递 id 任务名称(name)、内容(content)、状态(state 注意是布尔类型))
    @RequestMapping(value = "/updateTask", method = RequestMethod.PUT)
    @ResponseBody
    public SiteResponse updateTask(@RequestBody Task task) {
        //设置值,若前端传递则可删除
//        task.setId(17);
//        task.setName("安装win7");
//        task.setContent("找3DM");
//        task.setState(true);   //!此处是布尔类型 (前端需要传递布尔类型)

        return taskServise.updateTask(task);
    }

    //查询个人任务
    @RequestMapping(value = "/findOneTask", method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse findOneTask(Task task) {
//        task.setExecutor(28);  //设置一个执行者(用户的id)的值取查询
        //将loginUser long to int
//        String a =   String.valueOf(loginUser);
//        int executor =   Integer.valueOf(a);
//        task.setExecutor(executor);
        return taskServise.findOneTask(task);
    }

    //查询任务表 所有内容 (无需参数)
    @RequestMapping(value = "/searchTask", method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse searchTask() {
        return taskServise.searchTesk();
    }
/******************************    分页模块     *************************************/
    //返回前端 任务分页总页数
    @RequestMapping(value = "/taskEntry", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse taskEntry(@RequestBody Task task) {
        return taskServise.taskEntry(task);
    }
    //返回前端 每页显示的数据
    @RequestMapping(value = "/getTaskPaging", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse getTaskPaging(@RequestBody Task task) {
        return taskServise.getTaskPaging(task); //一页显示 entry条的话 , 第 Page 页 应该显示的内容
    }
}