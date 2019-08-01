package com.spring.aop.aspectj;


import org.aspectj.lang.JoinPoint;

import java.util.Arrays;
//切面类
public class LogAdvice {
    //自定义增强的方法内容
    public void myBefore(JoinPoint point){
        //获取方法名代理对象的方法名
        String methodName = point.getSignature().getName();
        Object[] params = point.getArgs();
        //类的全路径名
        String clsName = point.getTarget().getClass().getName();
        //
        String kind = point.getKind();
        System.out.println(methodName+"******前置通知********|"+ Arrays.toString(params)+""+kind+"|=="+clsName);
    }

    public void myAfter(){
        System.out.println("*********最终通知*******");
    }

    public void myAfterReturn(){
        System.out.println("*********后置通知*******");
    }

}
