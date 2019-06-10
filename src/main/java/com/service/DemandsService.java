package com.service;

import com.ToolMethod.GetTime;
import com.base.ServiceContain;
import com.pojo.Demands;
import com.pojo.User;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class DemandsService extends ServiceContain {

    //添加需求
    public SiteResponse addDemands(Demands demands) {

        if (loginUser == 0) {
            return returnResponse("0", "你还没有登陆", true);
        } else {
            String creat_time = new GetTime().GetTime();
            System.out.println("当前登陆的用户编号:" + loginUser);

            HttpSession session1 = request.getSession();
            User user1 = (User) session1.getAttribute("userSession");
            //转换 user1 里面的long 类型 id 为int
            String a = String.valueOf(user1.getId());
            int id = Integer.valueOf(a);
            demands.setCreator(id);
            demandsMapper.addDemands(demands, creat_time);
            return returnResponse("1", "添加需求成功", true);
        }
    }

    //删除需求
    public SiteResponse delDemands(Demands demands) {
        if (loginUser == 0) {
            return returnResponse("0", "你还没有登陆", true);
        } else {
            demandsMapper.delDemands(demands);
            return returnResponse("1", "删除需求成功", true);
        }
    }

    //批量删除需求
    public SiteResponse dmDemands(String[] arrs) {

        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
            Integer arr = Integer.valueOf(arrs[i]); //把数组的每个元素分别转换成Interger类型
            demandsMapper.dmDemands(arr);
        }
        return returnResponse("1", "批量删除需求成功", true);
    }

    //修改需求
    public SiteResponse updateDemands(Demands demands) {
        demandsMapper.updateDemands(demands);
        return returnResponse("1", "修改需求成功", true);
    }

    //查询所有需求
    public SiteResponse searchDemands() {
        List<Demands> demandsList = demandsMapper.searchDemands();
        System.out.println("总共有需求:" + demandsList.size() + "条");
        return returnResponse(demandsList, "需求查询完成", true);
    }

    //返回前端(页面总数)
    public SiteResponse demandsEntry(Demands demands) {
        if (demands.getEntry() <= 0) {
            return returnResponse("0", "页数或页面显示条目不符合规范", false);
        } else {
            // 总页数
            int allPage = 0;
            List<Demands> demandsList = demandsMapper.searchDemands();
            int allEntry = demandsList.size();
            if (allEntry % demands.getEntry() == 0) {
                allPage = allEntry / demands.getEntry();
                System.out.println("除尽时总页数:" + allPage);
                return returnResponse(allPage, "需求总页数发送成功", true);
            } else {
                allPage = allEntry / demands.getEntry() + 1;
                System.out.println("非除尽时总页数:" + allPage);
                return returnResponse(allPage, "需求总页数发送成功", true);
            }
        }
    }

    //分页处理
    public SiteResponse getDemandsPaging(Demands demands) { // 一页记录条数(默认页面条数4) , 当前页码 (默认当前第1页)
        if (demands.getEntry() <= 0 || demands.getPage() <= 0) {
            return returnResponse("0", "页数或页面显示条目不符合规范", false);
        } else {
            //起点表达式
            demands.setPageStart(demands.getPage() * demands.getEntry() - demands.getEntry());
            //调用分页方法(获取每页得到的数据)
            List<Demands> pageDemands = demandsMapper.getDemandsPaging(demands);
            /*************编辑区***************/
            for (Demands d: pageDemands) {
                System.out.println("获取到的需求名称: " + d.getName() );
            }
            /**************编辑区**************/
            //返回给前端 每页需求的一个集合
            return returnResponse(pageDemands, "当前页面显示需求发送成功", true);
        }
    }

    //为任务模块服务
    public SiteResponse getOneDemands(int id) {
        List<Demands> demandsList = demandsMapper.getOneDemands(id);
        return returnResponse(demandsList, "查询一个需求完成", true);
    }
}
