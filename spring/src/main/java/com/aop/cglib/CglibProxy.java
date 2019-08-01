package com.aop.cglib;

import com.aop.SaleTicket;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 基于cglib实现的动态代理
 */
public class CglibProxy implements MethodInterceptor {
    public Object  CglibProxy(Object o) {
        //创建enhancer类作为待代理对象的子类
        Enhancer enhancer=new Enhancer();
        //设置enchancer的父类，即待代理对象o
        enhancer.setSuperclass(o.getClass());
        //设置回调函数执行的类，this
        enhancer.setCallback(this);

        Object proxy = enhancer.create();
        return proxy;
    }

    /**
     * 回调函数
     * @param o 代理对象
     * @param method
     * @param objects
     * @param methodProxy 代理对象的方法
     * @return 返回代理对象
     * @throws Throwable
     */

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行前======================");
        Object aSuper = methodProxy.invokeSuper(o, objects);
        System.out.println("执行后======================");
        return o;
    }
}
