package com.mapper;


import com.base.ServiceContain;
import com.pojo.MyFile;
import com.pojo.User;
import org.apache.ibatis.annotations.Param;

//该接口主要提供给拦截器使用
public interface FileIntoBaseMapper {
    void FileInfoIntoDataBase(@Param("fname") String fname ,@Param("date") String date);
}
