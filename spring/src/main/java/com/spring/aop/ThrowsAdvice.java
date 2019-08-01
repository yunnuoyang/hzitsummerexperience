package com.spring.aop;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class ThrowsAdvice implements org.springframework.aop.ThrowsAdvice {
    private Logger logger=Logger.getLogger("ThrowsAdvice");
    public void ThrowsAdvice() {
        logger.info("ThrowsAdvice在运行..............."+new SimpleDateFormat().format(new Date(System.currentTimeMillis())));

    }
    public void afterThrowing(Method method, Object[] args, Object target, Throwable subclass){
        System.err.println("[异常日志]\n    时间：" + new Date()
                + "\n  业务类：" + target.getClass().getName()
                + "\n业务方法："+ method.getName()
                + "\n    参数："+ printArray(args)
                + "\n异常信息："+ subclass.getMessage()
                + "\n堆栈信息：" + subclass.getStackTrace());
        System.out.println("\n*************************异常通知结束****************************");
    }
    private String printArray(Object[] args){
        String s = "";
        for(Object o : args){
            s += o.toString();
        }
        return s;
    }
}
