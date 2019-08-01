package com.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        AopService proxy = (AopService) context.getBean("proxy");
        proxy.post();
    }
}
