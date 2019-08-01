package com.spring.aop;

import org.slf4j.Logger;

/**
 * 测试aop的service
 */
public class AopService {
    public void post(){int a=5/0;
        System.out.println("===========AopService===========");
    }
}
