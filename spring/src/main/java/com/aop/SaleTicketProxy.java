package com.aop;

/**
 * 代理售票点
 * spring切面
 */
public class SaleTicketProxy implements ISaleTicket{
    private ISaleTicket saleTicket;
    SaleTicketProxy(ISaleTicket saleTicket){
        this.saleTicket=saleTicket;
    }
    //spring切点
    public void sale(){
        //模拟前置增强
        System.out.println("=====收费五元====");
        this.saleTicket.sale();
        //模拟后置增强
        System.out.println("=====慢走，一路顺风====");
    }
}
