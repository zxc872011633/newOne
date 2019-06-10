package com.AOP;
import com.base.ServiceContain;
import com.pojo.deleteLog;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAndAfter extends ServiceContain {
 //   @AfterReturning(returning = "object", value = "execution(* com.mapper.UserMapper.*(..))") //参数指向的文件是下面执行方法的参照
     @AfterReturning(returning = "object", value = "execution(* com.mapper.UserMapper.delete(Object))") // 仅仅拦截delete方法
     //* com.mapper.UserMapper.delete(Object))"
    public void after(Object object) {
        int delid = arr[0];
        String s2 = String.valueOf(delid); //将int类型强制转化为字符串
        s1 = "你删除了id为:";
        s1 = s1.concat(s2);
        deleteLog deleteLog = new deleteLog();
        delMapper.insertIntoDatabase(deleteLog,delid,s1);
//         System.out.println("拦截成功");
    }
}
