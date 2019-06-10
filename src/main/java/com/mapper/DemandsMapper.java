package com.mapper;

import com.pojo.Demands;
import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemandsMapper {

    void addDemands(@Param("Pojo") Demands demands, @Param("creat_time") String creat_time);
    void delDemands(@Param("Pojo") Demands demands);
    void dmDemands(@Param("Array") Integer arr );   //批量删除
    void updateDemands(@Param("Pojo") Demands demands);
    List<Demands> searchDemands();
    //返回前端数据 每页显示需求
    List<Demands> getDemandsPaging(@Param("Pojo") Demands demands);
    //为任务模块服务 (为了分配任务 查询 需求id 的全部任务)
    List<Demands> getOneDemands(@Param("DemandsId") int id);
}
