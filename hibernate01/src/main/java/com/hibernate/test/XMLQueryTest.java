package com.hibernate.test;

import com.hibernate.pojo.Detail;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

public class XMLQueryTest {
    /**
     * XML中的sql-query
     */
    @Test
    public void test1(){
        Session session = HibernateUtils.getSession();
        Query<Detail> query = session.createNamedQuery("allDetails", Detail.class);
        query.list()
                .forEach((d)->{
                    System.out.println(d.getUsername()+d.getBirthday());
                });
    }
    /**
     * XML中的query
     */
    @Test
    public void test2(){
        Session session = HibernateUtils.getSession();
        Query<Detail> query = session.createNamedQuery("allDetails2", Detail.class);
        query.list()
                .forEach((d)->{
                    System.out.println(d.getUsername()+d.getBirthday());
                });
    }
}
