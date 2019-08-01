package com.spring.aop.aspectj;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext
                        ("com.spring.aop.aspectj/applicationContext.xml");
        AopService service = (AopService) context.getBean("service");
        service.post("哈哈哈");
    }
    @org.junit.Test
    public void test(){
        int b='2';
        int a=1%2;
        System.out.println(a+"=="+b);

//        Vector
//        ArrayList
//        LinkedList
//        List
//        TreeMap
        Collection
    }


    public Test() {
        test();
    }
}
