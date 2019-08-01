package com.spring.aop;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Arrays;
import java.util.logging.Logger;

public class BeforeAop implements MethodBeforeAdvice {
    private Logger logger=Logger.getLogger("BeforeAop");
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(method.getName()+"前置增强。。。。。。。。。。。");
        logger.info("当前系统时间"+new Date(System.currentTimeMillis())+""+ Arrays.toString(objects)+"所在类"+o.getClass().getName());
    }
}
