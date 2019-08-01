package com.aop;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TryProxy implements InvocationHandler {
    private Object object;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(proxy, args);
        return proxy;
    }
    public Object getNewInstance(Object object,String methodName,Object... args){
        try {
            return this.invoke(object,object.getClass().getDeclaredMethod(methodName),args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Test
    public void test(){
        ISaleTicket iSaleTicket=new SaleTicket();
        TryProxy tryProxy = new TryProxy();
        ISaleTicket sale = (ISaleTicket) getNewInstance(iSaleTicket, "sale", null);
        sale.sale();
    }
}
