package com.UploadAndDownLoad;
import com.mapper.FileUpLoad;
import java.io.*;
import java.nio.file.Files;
import static com.FileDemo.UpLoadFiles;

public class ForUpLoad implements  FileUpLoad  {   //该接口实现类为拦截对象(拦截其所有方法)
    /*                    创建文件的方法                 */
    public void CreatFile(String fileSrc) {
        try{
//          File file = new File("D:\\test\\test.mp3");
            File file = new File(fileSrc); //给一个路径让其自动创建

            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
                System.out.println("父级目录不存在,程序创建了一个父级目录文件");
            }

            if(!file.exists()){
                file.createNewFile();
                System.out.println("文件不存在,程序创建了一个文件");
            }
        }catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println("文件创建完成!");
    }

    /*                               上传单个文件方法                    */
    @Override
    public void UploadFile(String flieSrc1, String fileSrc2) throws IOException{
        try{
//            File file1 = new File("D:\\test\\test.txt");  //要上传的文件路径
//            File file2 = new File("D:\\test.txt");        //上传到的地址(顺便给文件从命名,注意格式的一致性)

            File file1 = new File(flieSrc1);
            File file2 = new File(fileSrc2);
            if(!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
                System.out.println("父级目录不存在,程序创建了一个父级目录文件");
            }
            Files.copy(file1.toPath(),file2.toPath());
            System.out.println("文件上传完成!");
        }catch (Exception e) {
            e.getStackTrace();
            System.out.println("操作出错,请检查是否存在在该文件");
        }
    }

   /*                               上传多个文件方法                    */
    public void UploadFiles(String src, String des) {
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
                try {
                    fileCopy(f.getPath(), des + "\\" + f.getName()); //调用下面的文件复制方法
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (f.isDirectory()) {
                //如果里面有文件夹
                try {
                    UpLoadFiles(f.getPath(), des + "\\" + f.getName()); //继续调用文件夹上传的办法
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("文件上传完成!");
    }

    //上传单个文件方法()和上面的方法一起的
    public void fileCopy(String src, String des) throws Exception { //为了不让其他类访问到此方法我们设置为私有方法
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
