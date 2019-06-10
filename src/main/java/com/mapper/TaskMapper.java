package com.mapper;

import com.pojo.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    //分配任务
    void assTask (@Param("Pojo") Task task,@Param("startTime") String startTime);
    //删除任务
    void delTask (@Param("Pojo") Task task);
    //修改任务
    void updateTask (@Param("Pojo") Task task);
    //查询任务表(个人任务)
    List<Task> findOneTask (@Param("Pojo") Task task);
    //查询任务表(全部内容)
    List<Task> searchTask ();
    //完成任务记录
    void finishTask(@Param("Pojo") Task task,@Param("finish_time") String finish_time);
    //返回前端 每页显示的数据
    List<Task> getTaskPaging(@Param("Pojo") Task task);


    //查询任务表(根据id 辅助删除任务的逻辑若完成了任务则不能删除)
    List<Task> findTaskById (@Param("Pojo") Task task);
    //写入需求表(用户放弃的任务 放回需求表)
    void putIntoDemands(@Param("Pojo") Task task ,@Param("Create_time")String create_time);
}