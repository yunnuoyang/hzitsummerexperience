package com.aop;

import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的类
 */
public class DyNProxy implements InvocationHandler {
    private Object object;
   DyNProxy(){

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(this.object, args);
        System.out.println("======"+invoke+"======");
//        System.out.println(invoke.equals(this.object));
        return object;
    }
    public Object getObject(Object object){
       this.object=object;
       return Proxy.newProxyInstance(this.object.getClass().getClassLoader(),this.object.getClass().getInterfaces(),this);
    }




}
