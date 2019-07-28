package com.hibernate.test;

import com.hibernate.pojo.Account;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.predicate.CompoundPredicate;
import org.hibernate.tuple.entity.EntityTuplizerFactory;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QBCtest {

    /**
     * QBC之where查询
     */
    @Test
    public void test1(){
        Session session = HibernateUtils.getSession();
        // 获得CriteriaBuilder 用来创建CriteriaQuery
        CriteriaBuilder builder = session.getCriteriaBuilder();
        // 创建CriteriaQuery 参数为返回结果类型
        CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
        // 返会查询表 参数类型为要查询的持久类
        Root<Account> root = criteria.from(Account.class);
        // 设置where条件
        criteria.where(builder.equal(root.get("accname"), "3424556"));
        // 创建query 查询
        Query<Account> query = session.createQuery(criteria);
        // 返回结果
        Account account = query.getSingleResult();
        System.out.println(account.getAccname()+account.getAccpass());
    }

    /**
     *查询总数目
     */
    @Test
    public void test2(){
        Session session = HibernateUtils.getSession();
        // 获得CriteriaBuilder 用来创建CriteriaQuery
        CriteriaBuilder builder = session.getCriteriaBuilder();
        // 参数为查询的结果类型
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        // 从什么表查询
        Root<Account> root = criteria.from(Account.class);
        // 就是sql select 之后的语句
        criteria.select(builder.count(root));
        // 使用query 实现查询
        Query<Long> query = session.createQuery(criteria);
        // 结果集
        Long result = query.uniqueResult();
        System.out.println(result);
    }
}
