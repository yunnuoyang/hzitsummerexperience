package com.aop;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;

public class Test {
    public static void main(String[] args) {
//        ISaleTicket saleTicketProxy=new SaleTicketProxy(new SaleTicket());
//        saleTicketProxy.sale();
        ISaleTicket saleTicket=new SaleTicket();
        DyNProxy dyNProxy=new DyNProxy();
        ISaleTicket object = (ISaleTicket) dyNProxy.getObject(saleTicket);
        object.sale();
//        MyProxy myProxy=new MyProxy(saleTicket);
//        ISaleTicket obj = (ISaleTicket) myProxy.getObj();
//        obj.sale();
    }
    @org.junit.Test
    public void test(){
        Enhancer enhancer=new Enhancer();
        ISaleTicket saleTicket=new SaleTicket();
        Object o = enhancer.create(ISaleTicket.class,null);
    }
}
