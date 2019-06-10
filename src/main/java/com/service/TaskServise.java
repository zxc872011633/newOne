package com.service;

import com.ToolMethod.GetTime;
import com.base.ServiceContain;
import com.pojo.Demands;
import com.pojo.Task;
import com.pojo.User;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class TaskServise extends ServiceContain {
    /******************分配任务****************/
    public SiteResponse assTask(Task task) {

        if (loginUser == 0) {
            return returnResponse("0", "请在登陆后操作", false);
        } else {
//          task.setId(106);  //   当作   需求的id
            int demandsid = task.getId();   //接收一个 需求的id
            List<Demands> demandsList = demandsMapper.getOneDemands(demandsid);  //根据前端传递的需求id来获取每一个字段
            //拿到需求表内容
            for (Demands i : demandsList) {
                System.out.println("需求名称:" + i.getName() + "需求内容:" + i.getContent() +
                        "创建时间:" + i.getCreate_time() + "创建人:" + i.getCreator());
                task.setName(i.getName());
                task.setContent(i.getContent());
                task.setCreate_time(i.getCreate_time());
                task.setCreator(i.getCreator());
            }
            //把分配过的(需求)任务删除
            Demands demands = new Demands();
            demands.setId(demandsid);
            demandsMapper.delDemands(demands);

            // 获取 接收任务者 user 的id 并 转化为int,把值设置给task
            HttpSession session1 = request.getSession();
            User user1 = (User) session1.getAttribute("userSession");
            String executor1 = String.valueOf(user1.getId());
            int executor2 = Integer.valueOf(executor1);

            task.setExecutor(executor2);
            System.out.print("在对象里面获取到的值:" + task.getName());

            String starttime = new GetTime().GetTime();
            taskMapper.assTask(task, starttime);
            return returnResponse("1", "个人 分配(领取)任务成功", true);
        }
    }


    /******************完成任务****************/
    public SiteResponse finishTask(Task task) {
        taskMapper.finishTask(task, new GetTime().GetTime());
        return returnResponse("1", "任务已完成", true);
    }

    //删除任务
    public SiteResponse delTask(Task task) {
        List<Task> rs = taskMapper.findTaskById(task);
        int j = 1;
        for (Task i : rs) {
            if (i.isState()) {
                j = 0;
                System.out.println("已完成的任务不可删除");
            } else {
                taskMapper.delTask(task);
                System.out.println("删除任务完成");
                //初始化格式化时间工具
                GetTime rule = new GetTime();
                String create_time = rule.ChageTimeRule(i.getCreate_time());

                task.setName(i.getName());
                task.setContent(i.getContent());
                task.setCreator(i.getCreator());

                taskMapper.putIntoDemands(task, create_time);
            }
        }

        if (j == 0) {     //根据判断 j 的值, 把两句返回语句写到一起
            return returnResponse("0", "已完成的任务不可删除", false);
        } else {
            return returnResponse("1", "任务删除完成", true);
        }
    }

    //修改任务
    public SiteResponse updateTask(Task task) {
        if (task.getName().equals("") || task.getContent().equals("") || task.getName() == "" || task.getContent() == "") {
            return returnResponse("任务名称或任务内容为空,不符合规范", "修改失败", false);
        }
        taskMapper.updateTask(task);
        return returnResponse("1", "修改任务成功", true);
    }

    //查询任务(个人任务)
    public SiteResponse findOneTask(Task task) {
        // session获取对象,从对象取值,转换类型, 给task设置值
        HttpSession session1 = request.getSession();
        User user1 = (User) session1.getAttribute("userSession");
        String executor1 = String.valueOf(user1.getId());
        int executor2 = Integer.valueOf(executor1);
        task.setExecutor(executor2);

        List<Task> rs = taskMapper.findOneTask(task);
        System.out.println("任务模块,查询个人任务的内容长度" + rs.size());

        for (Task i : rs) {
            System.out.println("该用户领取的任务名分别是:" + i.getName());
        }

        return returnResponse(rs, "任务查询完成", true);
    }

    //查询任务(查询出全部内容 无需参数)
    public SiteResponse searchTesk() {
        List<Task> rs = taskMapper.searchTask();
        for (Task i : rs) {
            System.out.println("任务名:" + i.getName());
        }
        return returnResponse(rs, "任务查询完成", true);
    }

    //返回前端总 任务总共页数
    public SiteResponse taskEntry(Task task) {
        if (task.getEntry() <= 0) {
            return returnResponse("0", "页数或页面显示条目不符合规范", false);
        } else {
            // 初始化总页数
            int allPage = 0;
            List<Task> rs = taskMapper.searchTask();
            //获取到任务总条数
            int allEntry = rs.size();
            //返回页数逻辑
            if (allEntry % task.getEntry() == 0) {
                allPage = allEntry / task.getEntry();
                System.out.println("除尽时总页数:" + allPage);
                return returnResponse(allPage, "任务总页数发送成功", true);
            } else {
                allPage = allEntry /task.getEntry() + 1;
                System.out.println("非除尽时总页数:" + allPage);
                return returnResponse(allPage, "任务总页数发送成功", true);
            }
        }
    }

    //返回前端 每页显示的数据
    public SiteResponse getTaskPaging(Task task) { // 一页记录条数(默认页面条数4) , 当前页码 (默认当前第1页)
        if (task.getEntry() <= 0 || task.getPage() <= 0) {
            return returnResponse("0", "页数或页面显示条目不符合规范", false);
        } else {
            //设置起点
            int pageStart = 0;
            //起点表达式
            task.setPageStart(task.getPage() * task.getEntry() - task.getEntry());
            //调用分页方法(获取每页得到的数据)
            List<Task> pageDemands = taskMapper.getTaskPaging(task);
            /*************编辑区***************/
            for (Task task1: pageDemands) {
                System.out.println("获取到的任务名称: " + task1.getName() );
            }
            /**************编辑区**************/
            //返回给前端 每页需求的一个集合
            return returnResponse(pageDemands, "任务显示数据发送成功", true);
        }
    }
}
