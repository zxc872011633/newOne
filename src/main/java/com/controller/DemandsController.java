package com.controller;

import com.ToolMethod.CutString;
import com.base.ServiceContain;
import com.pojo.Demands;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/demands")
public class DemandsController extends ServiceContain {

    //添加需求
    @RequestMapping(value = "/addDemands", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse addDemands(@RequestBody Demands demands) {
        System.out.println("需求名是:" + "需求内容:" + "创建人:");
//        demands.setName("464646");
//        demands.setContent("449499499");
//        demands.setCreator(12345678);
//        demands.setCreator((int)loginUser);
        return demandsService.addDemands(demands);
    }

    //删除需求
    @RequestMapping(value = "/delDemands", method = RequestMethod.DELETE)
    @ResponseBody
    public SiteResponse delDemands(@RequestBody Demands demands) {
//            demands.setId(5);
        System.out.println(demands.getId());
        return demandsService.delDemands(demands);
    }

    //批量删除需求
    @RequestMapping(value = "/dmDemands", method = RequestMethod.DELETE)
    @ResponseBody
    public SiteResponse dmDemands(@RequestBody String arrs) {
        System.out.println(arrs);
        return demandsService.dmDemands(CutString.cutString(arrs));
    }

    //修改需求
    @RequestMapping(value = "/updateDemands", method = RequestMethod.PUT)
    @ResponseBody
    public SiteResponse updateDemands(@RequestBody Demands demands) {
//        demands.setId(4);
//        demands.setName("修改了2");
//        demands.setContent("无限修改2");
        return demandsService.updateDemands(demands);
    }

    //返回总页数        (测试完成 !合并方法到分页方法当中!)
    @RequestMapping(value = "/demandsEntry", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse demandsEntry(@RequestBody Demands demands) {
        return demandsService.demandsEntry(demands);
    }

    //分页处理
    @RequestMapping(value = "/getDemandsPaging", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse getDemandsPaging(@RequestBody Demands demands) {
        return demandsService.getDemandsPaging(demands);
    }

    //查询所有需求
    @RequestMapping(value = "/searchDemands", method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse searchDemands() {
        return demandsService.searchDemands();
    }
}