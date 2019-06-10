package com.base;

import com.UploadAndDownLoad.ForUpLoad;
import com.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by li on 2017/11/27.
 */
@Mapper
public class MapperContain {
    //用户
    @Autowired
    public UserMapper userMapper;
    @Autowired
    public DelMapper delMapper;
    @Autowired
    public DemandsMapper demandsMapper;
    @Autowired
    public TaskMapper taskMapper;
    @Autowired
    public FileUpLoad fileUpLoad; //上传文件功能的接口
    @Autowired
    public FileIntoBaseMapper fileIntoBaseMapper; // 拦截上传之后,写入数据库信息的功能接口

    @Autowired
    public ApplicationContext applicationContext;

}
