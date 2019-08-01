package com.spring.aop;

import org.springframework.aop.AfterReturningAdvice;
import sun.rmi.runtime.Log;

import java.lang.reflect.Method;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 后置增强
 */
    public class AdviceAfterReturning implements AfterReturningAdvice {
        private Logger logger=Logger.getLogger("AdviceAfterReturning");
    private static DateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
    @Override
    public void afterReturning(Object result, Method method, Object[] arg2, Object arg3) throws Throwable {
        System.out.println("\n后置通知开始：");
        logger.info("[后置通知：系统日志][" + sdf.format(new Date(System.currentTimeMillis())) + "]"
                + "\n类名："+arg3.getClass()
                + "\n方法名："+method.getName()
                + "\n参数：("+ Arrays.toString(arg2)
                + "\n方法返回结果："+result
                + ")====结束\n");
        System.out.println("*************************后置通知结束****************************");
    }
}
