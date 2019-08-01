package com.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕通知
 * 通过使用invocation.proceed()可以决定业务类方法执行的位置
 */
public class AdviceAround implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {

		System.out.println("\n环绕通知开始：");
		invocation.proceed();
		System.out.println("--------后置通知-----");
//        Object[] args = invocation.getArguments();  //包括参数
//
//        System.out.println("类名:" + invocation.getThis().getClass());
//        System.out.println("方法名称:" + invocation.getMethod().getName());
//        System.out.println("传入参数：");
//        for(Object arg: args) {
//            System.out.println("参数类型："+arg.getClass().getName() + "= 参数值：" + arg);
//        }
//        System.out.println("返回的结果："+invocation.proceed());
//        //修改了目标方法返回值   这里invocation.proceed()是原来方法的返回值，
//        //最终的方法返回值是这里的修改后的返回值
//        System.out.println("*************************环绕通知结束****************************");

		return false;
	}

}
