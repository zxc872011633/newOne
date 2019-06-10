package com.service;


import com.ToolMethod.GetFileName;
import com.ToolMethod.GetTheTileName;
import com.ToolMethod.GetTime;
import com.base.ServiceContain;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;

@Service
public class UploadService extends ServiceContain {

    //forUpLoad 文件功能接口的实现类对象
    public void addFile() throws Exception {
        String src1 = "D:\\test\\test.txt";
        String src2 = "D:\\test.txt";
        forUpLoad.UploadFile(src1, src2);
        String fname = new GetTheTileName().GetTheTileName(src1); //或取上传的文件名字
        fileinfo[0] = fname;    //储存这个文件名到Servicecontain里面的数组中
        fileinfo[1] = new GetTime().GetTime();    // 把时间放入数组
        //System.out.println("储存内容是:" + fileinfo[0]);
    }

    public void addFiles() throws Exception {
        String src1 = "E:\\down\\speedpan";
        String src2 = "D:\\dest\\";
        forUpLoad.UploadFiles(src1, src2);
        String fname = new GetTheTileName().GetTheTileName(src1); //或取上传的文件名字
        fileinfo[0] = fname;    //储存这个文件名到Servicecontain里面的数组中
        fileinfo[1] = new GetTime().GetTime();    // 把时间放入数组
    }


    public void addFileTest(MultipartFile file) {
        InputStream inputStream = null;
        OutputStream os = null;
        //定义文件名变量
        String fileName = null;
        try {
            inputStream = file.getInputStream();
            fileName = file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 2、保存到临时文件
            String path = "D:\\test\\";
//            String path = "C:\\inetpub\\wwwroot";
            // 1K的数据缓冲
            byte[] bs = new byte[1024 * 100];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public SiteResponse getImgName(String path) {
        ArrayList<String> allName = new ArrayList<String>();
        //路径下的文件名全部储存在了 AllName
        GetFileName.getAllFileName(path, allName);
        for (String name : allName) {
            System.out.println(name);
        }
        return returnResponse(allName, "返回指定路径内容成功", true);
    }
}