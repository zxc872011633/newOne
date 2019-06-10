package com;

import com.base.ServiceContain;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by li on 2018/1/3.
 */
@SpringBootApplication
@MapperScan("com.mapper")
public class SampleController extends ServiceContain {
    //直接打开com.mapper映射进入程序流程
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
        System.out.println("执行结束");
    }
}
