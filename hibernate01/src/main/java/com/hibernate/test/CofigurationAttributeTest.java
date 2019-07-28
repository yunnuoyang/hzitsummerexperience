package com.hibernate.test;

import com.hibernate.pojo.GoodsEntity;
import com.hibernate.pojo.People;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * 测试fetch,order-by,fetch-size,等属性的作用
 */
public class CofigurationAttributeTest {
    /**
     * fetch:在一对多的主表即一的一方进行配置
     * 当fetch=join 时，发送内连接查询，查询一的一方的单条数据会产生左连接查询可能会有迪卡尔积的问题，适合数据量小的查询，
     * select people0_.id as id1_4_0_, people0_.name as name2_4_0_, people0_.year as year3_4_0_, goodsentit1_.pid as pid4_3_1_, goodsentit1_.id as id1_3_1_, goodsentit1_.id as id1_3_2_,
     * goodsentit1_.goods_name as goods_na2_3_2_, goodsentit1_.goods_price as goods_pr3_3_2_, goodsentit1_.pid as pid4_3_2_ from
     * people people0_ left outer join goods goodsentit1_ on people0_.id=goodsentit1_.pid where people0_.id=?
     * 当fetch=select 时，发送两条查询语句，可能会产生n+1问题，数据量大的情况下采用此种查询
     * Hibernate: select people0_.id as id1_4_0_, people0_.name as name2_4_0_, people0_.year as year3_4_0_ from people people0_ where people0_.id=?
     * Hibernate: select goodsentit0_.pid as pid4_3_0_, goodsentit0_.id as id1_3_0_, goodsentit0_.id as id1_3_1_, goodsentit0_.goods_name as goods_na2_3_1_,
     * goodsentit0_.goods_price as goods_pr3_3_1_, goodsentit0_.pid as pid4_3_1_ from goods goodsentit0_ where goodsentit0_.pid=?
     * 当fetch=subselect 时,发送两条语句，一条为子查询对一的一方的多条记录查询有效
     *
     */
    @Test
    public void test1(){
        Session session = HibernateUtils.getSession();
        Query<People> query = session.createQuery(" from People ", People.class);
        List<People> list = query.list();
        list.forEach(people -> System.out.println(people.getName()+"=="+people.getGoodsEntities().size()));
    }

    /**
     *
     */
    @Test
    public void test2(){
        Session session = HibernateUtils.getSession();
        People people = session.get(People.class, 38);
        System.out.println(people.getName()+""+people.getGoodsEntities().size());

    }
    @Test
    public void test3(){
        Session session = HibernateUtils.getSession();
        GoodsEntity goodsEntity = session.get(GoodsEntity.class, 92l);
        System.out.println(goodsEntity.getGoodsName()+""+goodsEntity.getPeople());
    }
    @Test
    public void test4(){
        Session session = HibernateUtils.getSession();
        List<GoodsEntity > goodsEntity = session.createQuery("from GoodsEntity ",GoodsEntity.class).list();
      goodsEntity.forEach(goodsEntity1 -> System.out.println(goodsEntity1.getGoodsName()+""+goodsEntity1.getPeople().getName()));
    }

}

