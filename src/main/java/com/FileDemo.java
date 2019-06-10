package com;

import java.io.*;
import java.nio.file.Files;

public class FileDemo {

    public static void main(String[] args) throws Exception {

        //(文件夹)复制方法
       // UpLoadFiles("D:\\test","D:\\dest\\");

        //(单个文件)复制方法
        fileCopy("D:\\test\\test.mp3","D:\\dest\\");
        //打印完成
        System.out.println("文件拷贝完成!");
    }

    public static void UpLoadFiles(String src, String des) throws Exception {

        //初始化文
        File file1 = new File(src);
        //把文件内容放入(文件类)数组
        File[] fs = file1.listFiles();
        //初始化文件的粘贴
        File file2 = new File(des);
        //判断文件是否存在,如果没有就创建文件
        if (!file2.exists()) {
            file2.mkdirs();
        }
        //遍历文件及其文件夹
        for (File f : fs) {
            if (f.isFile()) {
                fileCopy(f.getPath(), des + "\\" + f.getName()); //调用下面的文件复制方法
            } else if (f.isDirectory()) {
                //如果里面有文件夹
                UpLoadFiles(f.getPath(), des + "\\" + f.getName()); //继续调用文件夹上传的办法
            }
        }
    }

 //复制单个文件的方法
    private static void fileCopy(String src, String des) throws Exception { //为了不让其他类访问到此方法我们设置为私有方法
        //io流固定格式
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));
        int i = -1;//记录获取长度
        byte[] bt = new byte[2014];//缓冲区
        while ((i = bis.read(bt)) != -1) {
            bos.write(bt, 0, i);
        }
        //关闭流
        bis.close();
        bos.close();
    }

}




