package com.hibernate.test;

import com.hibernate.pojo.Detail;
import com.hibernate.pojo.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class TestEhcache {

    @Test
    public  void test1(){
        Session session = HibernateUtils.getSession();
        People people = session.get(People.class, 38);
        System.out.println(people.getName()+""+people.getYear());
        session.close();
        Session session1 = HibernateUtils.getSession();
        People people1 = session1.get(People.class, 38);
        System.out.println(people1.getName()+""+people1.getYear());
        session.close();
    }
    @Test
    public void test2(){
        Session session=HibernateUtils.getSession();
        Detail detail = session.get(Detail.class, 2);
        System.out.println(detail.getEmail()+""+detail.getEmail());
        session.close();
        Session session1=HibernateUtils.getSession();
        Detail detail1 = session1.get(Detail.class, 2);
        System.out.println(detail1.getEmail()+""+detail1.getEmail());
        session.close();

    }
    @Test
    public void testQueryCache(){
        Session session=HibernateUtils.getSession();
        Query<Detail> query = session.createQuery("from Detail", Detail.class);
        query.setCacheable(true);
        query.list()
                .forEach(detail -> System.out.println(detail.getEmail()+""+detail.getEmail()));
        session.close();
        Session session1=HibernateUtils.getSession();
        Query<Detail> query1 = session1.createQuery("from Detail", Detail.class);
        query1.setCacheable(true);
        query1.list()
                .forEach(detail -> System.out.println(detail.getEmail()+""+detail.getEmail()));
        session1.close();
    }
}
