package com.mapper;

import java.io.IOException;

public interface FileUpLoad {
  public void CreatFile(String flieSrc); //创建文件方法
  public void UploadFile(String flieSrc1,String fileSrc2) throws IOException; //上传单个文件方法
  public void UploadFiles(String src,String des) throws IOException;  //上传文件夹方法
  public void fileCopy(String src, String des) throws Exception;     //辅助 UploadFiles 方法
}
