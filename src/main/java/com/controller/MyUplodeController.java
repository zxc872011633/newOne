package com.controller;

import com.base.ServiceContain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/file")
public class MyUplodeController extends ServiceContain {
    //上传单个文件
    @RequestMapping(value = "/addFile", method = RequestMethod.POST)
    @ResponseBody //必须加
    public void addFile(@RequestBody MultipartFile file) throws Exception {
        uploadService.addFile();
    }

    //上传多个文件
    @RequestMapping(value = "/addFiles", method = RequestMethod.POST)
    @ResponseBody
    public void addFiles() throws Exception {
        uploadService.addFiles();
    }

    //上传图片到后端 (前端传递过来调用方法,从后端拿需要开启IIS服务)
    @RequestMapping(value = "/addFileTest", method = RequestMethod.POST)
    @ResponseBody
    public void addFileTest(MultipartFile file) {
        uploadService.addFileTest(file);
    }

    //前端读图片的请求
    @RequestMapping(value = "/getImgName", method = RequestMethod.POST)
    @ResponseBody
    public void getImgName(/*String path*/) {
        uploadService.getImgName("D:\\test\\User");
    }
}