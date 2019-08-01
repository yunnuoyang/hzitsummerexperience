package com.aop;
//被代理对象
public class SaleTicket implements ISaleTicket{
    //spring织入点
    @Override
    public void sale(){
        System.out.println("=========================售票了=============================");
    }
}
