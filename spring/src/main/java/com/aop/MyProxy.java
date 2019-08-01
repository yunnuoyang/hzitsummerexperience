package com.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Date;

public class MyProxy implements InvocationHandler {
    private Object obj;
    MyProxy(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===售票时间===="+new Date(System.currentTimeMillis())+"======");
        proxy=this.obj;
        method.invoke(proxy,args);
        return proxy;
    }
    public Object getObj(){
        return Proxy.newProxyInstance(this.obj.getClass().getClassLoader(),this.obj.getClass().getInterfaces(),this);
    }
}
