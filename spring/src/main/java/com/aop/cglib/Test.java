package com.aop.cglib;

import com.aop.SaleTicket;

/**
 * 测试cglib代理的执行，不需要让被代理对象实现接口，
 * 使用代理对象给其创建一个子类，让子类来执行该方法
 */
public class Test {
    public static void main(String[] args) {
        SaleTicket saleTicket=new SaleTicket();
        CglibProxy cglibProxy=new CglibProxy();
        SaleTicket o = (SaleTicket) cglibProxy.CglibProxy(saleTicket);
        o.sale();
    }
}
