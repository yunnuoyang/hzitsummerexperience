package com.hibernate.test;

import com.hibernate.pojo.Account;
import com.hibernate.pojo.People;
import com.hibernate.pojo.Project;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.query.QueryProducer;
import org.hibernate.query.criteria.internal.path.PluralAttributePath;
import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.List;

public class HqlTest {
    @Test
    public void test1(){
        Session session = HibernateUtils.getSession();
        Query<People> people = session.createQuery("from People ", People.class);
        people.list()
                .stream()
                .filter(people1 -> people1.getName().contains("小"))
                .limit(3)
                .forEach((p)->System.out.println(p.getName()));
    }

    /**
     * 命名参数的方式
     */
    @Test
    public void test2(){
        Session session = HibernateUtils.getSession();
        Query<People> people = session.createQuery("from People where id=:a ", People.class)
                .setParameter("a",15);
        people.list()
                .forEach((p)->System.out.println(p.getName()));
    }

    /**
     * Query<Object[]> people中的泛型的变量的类型由参数的个数决定
     * 参数为多个，但不是全部属性值，则用Object数组进行接收，
     * 参数如果是单个则可以使用与之所对应的具体的属性类型进行接收
     */
    @Test
    public void test3(){
        Session session = HibernateUtils.getSession();
        Query<Object[]> people = session.createQuery("select id,name,year as y  from People where id=:a ")
                .setParameter("a",15);
        List<Object[]> list = people.list();
                list.forEach((p)->System.out.println(p[0]+""+p[1]+""+p[2]));
    }

    /**
     * Query中的返回的结果的类型可以是String，Object类型
     */
    @Test
    public void test4(){
        Session session = HibernateUtils.getSession();
        Query<String> people = session.createQuery("select name from People where id=:a ")
                .setParameter("a",15);
        List<String> list = people.list();
        list.forEach((p)->System.out.println(p));
    }

    /**
     * 一对一关系中设置lazy 延迟加载失效，一对一关系采用主表（既做主键又作外键）的配置关系
     * 在主表中设置constrained=true可以实现延迟加载
     */
    @Test
    public void test5(){
        Session session = HibernateUtils.getSession();
        Query<Account> people = session.createQuery("from Account ");
        List<Account> list = people.list();
        list.forEach((p)->System.out.println(p.getAccpass()+p.getDetailByAccid().getUsername()));
    }
    @Test
    public void test6(){
        Session session = HibernateUtils.getSession();
        //Asc升序，默认升序
        Query<Account> people = session.createQuery("from Account order by id desc");
        List<Account> list = people.list();
        list.forEach((p)->System.out.println(p.getAccid()+p.getDetailByAccid().getUsername()));
    }

    /**
     * 聚合语句
     */
    @Test
    public void test7(){
        Session session = HibernateUtils.getSession();
        Query<Object[]> objs=session.createQuery("select count(*),max(id),min(id),sum(id),avg(id) from Account");
        objs.list()
                .forEach((p)->System.out.println(p[0]+"总数量 "+p[1]+"最大值"+p[2]+"最小值"+p[3]+"总和"+p[4]+"平均数"));
    }

    /**
     * 分页 :分页查询的公式，当前页数据=（当前页页码-1）*每页总记录数
     */
    @Test
    public void test8(){
        Session session = HibernateUtils.getSession();
        Query<Account> people = session.createQuery("from Account");
        int curPage=2;//当前页页码
        int maxCount=2;//每页总记录数
        //设置每页总记录数
        people.setMaxResults(maxCount);
        //设置从当前数据记录开始计算
        people.setFirstResult((curPage-1)*maxCount);
        List<Account> list = people.list();
        list.forEach((p)->System.out.println(p.getAccid()+p.getDetailByAccid().getUsername()));
    }
    /**
     * 动态Sql:
     */
    @Test
    public void test9(){
        Session session = HibernateUtils.getSession();
        Query<Account> people = session.createQuery("from Account");
        CriteriaBuilder builder = session.getCriteriaBuilder();
        List<Account> list = people.list();
        list.forEach((p)->System.out.println(p.getAccid()+p.getDetailByAccid().getUsername()));
    }
}
