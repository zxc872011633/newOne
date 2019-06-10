package com.AOP;

import com.base.ServiceContain;
import com.pojo.MyFile;
import com.pojo.User;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FileOperatingInterceptor extends ServiceContain {   //该类为拦截器(拦截对象和拦截器要申明在配置文件里面)
    @AfterReturning(returning = "object", value = "execution(* com.service.UploadService.*(..))") //参数指向的文件是下面执行方法的参照
//    @Pointcut("execution(* com.mapper.FileUpLoad.*(..))")
//    private void allMethod() {
//    }
//    @AfterReturning("allMethod()")
    public void after(Object object) {
        System.out.println("拦截成功!");
        fileIntoBaseMapper.FileInfoIntoDataBase(fileinfo[0],fileinfo[1]); //参数是文件名和时间,从ServiceContain获取
        //调用接口方法传值
    }
}
