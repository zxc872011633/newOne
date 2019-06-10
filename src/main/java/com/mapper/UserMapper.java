package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created on 2018.08.14.
 */
public interface UserMapper {
    //    @Param 注解JavaBean对象
    List<User> search(@Param("Pojo") User user);
    List<User> searchAllUser();
    List<User> QueriesAlreadyExist (@Param("Pojo") User user);
    void insert(@Param("Pojo") User user,@Param("creat_time") String creat_time);
    void changeState(@Param("Pojo") User user);
    void rebootOneUser(@Param("Pojo") User user);
    void rebootAll();

    void delete(@Param("delteDemo") Object object);
    void update(@Param("Pojo") User user);
    // void delete(@Param("Pojo") User user,@Param("myid") int myid );
}
