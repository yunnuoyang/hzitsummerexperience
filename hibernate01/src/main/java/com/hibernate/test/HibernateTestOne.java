package com.hibernate.test;

import com.hibernate.pojo.Account;
import com.hibernate.pojo.Detail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.sql.Date;
/**
 * /**
 *  * 主键关联配置：
 *  *  1.主表对象的映射文件中增加<one-to-one></one-to-one>
 *  *    主表主键生成策略，普通策略(自增native)
 *  *  2.子表对象的映射文件中增加<one-to-one></one-to-one>
 *  *      还需要配置主键生成策略
 *  *      <generator class="foreign">
 *  *                 <param name="property">account</param>
 *  *       </generator>
 *  */


public class HibernateTestOne {
    @Test
    public void saveOneToOne(){
        Session session = HibernateUtils.getSession();
        Transaction tran = session.beginTransaction();
        Account account=new Account();
        account.setAccname("90738284848");
        account.setAccpass("中国邮政");
        Detail detail=new Detail();
        detail.setUsername("张三");
        detail.setBirthday(new Date(System.currentTimeMillis()));
        detail.setEmail("1334732898@qq.com");
        detail.setAccountByAccid(account);
        session.save(detail);
        tran.commit();
        session.close();
    }
    @Test
    public void getOneToOne(){
        Session session = HibernateUtils.getSession();
        Account account = session.load(Account.class, 2);
        System.out.println("================");
        System.out.println(account.getDetailByAccid().getUsername());
        session.close();
    }
}
