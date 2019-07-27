import com.hibernate.pojo.GoodsEntity;
import com.hibernate.pojo.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class HibernateTest {
        public static void main(String[] args) {
            //5.2以前的使用正向工程
//            Configuration cfg = new Configuration().configure();
//            SchemaExport export = new SchemaExport(cfg);
//            export.create(true, true);
        //5.2加载配置文件正向工程
//        ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//        Metadata metadata = new MetadataSources(registry).buildMetadata();
//        SchemaExport export = new SchemaExport();
//        export.create(EnumSet.of(TargetType.DATABASE),metadata);

//            getAndLoad();
    }


        @Test
        public void add(){
            Configuration configuration=new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            People people = new People();
            people.setName("小明");
            people.setYear(22);
            session.save(people);
            transaction.commit();
        }
    @Test
    public void del(){
        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        People people = new People();
        session.delete(people);
        transaction.commit();
        session.close();
    }
    @Test
    public  void getAndLoad(){
        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        GoodsEntity goodsEntity = session.load(GoodsEntity.class, 6l);
        System.out.println("***************");
        System.out.println("===="+goodsEntity.getGoodsName());
        session.close();
    }
    @Test
    public  void moneyToOneSave(){
        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        People people=new People();
        people.setName("小王");
        people.setYear(20l);
        GoodsEntity goodsEntity=new GoodsEntity();
        goodsEntity.setGoodsName("瓜子");
        goodsEntity.setGoodsPrice(33);
        goodsEntity.setPeople(people);
//        session.save(people);
        session.save(goodsEntity);
        transaction.commit();
        session.close();
    }
    @Test
    public  void oneToMonetSearch(){
        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();
//        People people = session.load(People.class, 1);
//        System.out.println("***************");
//        System.out.println("===="+people.getName());
//        for(GoodsEntity goodsEntity:people.getGoodsEntities()){
//            System.out.println(goodsEntity.getGoodsName());
//        }
        GoodsEntity goodsEntity=new GoodsEntity();
        goodsEntity.setGoodsName("电冰箱");
        goodsEntity.setGoodsPrice(2000);
        GoodsEntity goodsEntity1=new GoodsEntity();
        goodsEntity1.setGoodsName("电视机");
        goodsEntity1.setGoodsPrice(2000);
        People people=new People();
        people.setName("奉先");
        people.setYear(40l);
        Set<GoodsEntity> goodsEntities = people.getGoodsEntities();
        goodsEntities.add(goodsEntity);
        goodsEntities.add(goodsEntity1);
        people.setGoodsEntities(goodsEntities);
        session.save(people);
        tran.commit();
        session.close();
    }
}
