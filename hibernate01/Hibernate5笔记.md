### Hibernate5笔记

#### hibernate的三态

hibernate由游离态，持久态，瞬时态。

游离态：session中没有，数据库中有此对象

持久态：session中有，数据库中也有

瞬时态：对象刚刚创建，session中没有，数据库中也没有。

补充（mysql是关系型数据库，存储与硬盘中。读写速度必定低于h2等内存数据库。除了关系型数据库还有nosql数据库，如redis,mongodb,直接存储对象）

#### 持久化，序列化

持久化概念是指将内存中的数据以文件的形式存储在文件中。如，一个应用程序中的数据存储在数据库中，excel,txt等文件都可以作为数据的持久化存储文件。

序列化是指将对象以流的方式进行存储、传输。具有序列化id唯一可以进行反序列化。

#### ORM概念

orm是指对象关系映射技术（Object Relation Mapping）,并不只是hibernate所具有的特殊功能。是一种泛指的概念。hibernate是全自动的orm框架，类似的半自动化框架还有mybatis。jpa是Java Persistence API的简称中文名Java持久层API，是JDK 5.0注解或XML描述对象－关系表的映射关系，并将运行期的实体对象持久化到数据库中。

​	PA的总体思想和现有Hibernate、TopLink、JDO等ORM框架大体一致。总的来说，JPA包括以下3方面的技术：

**ORM映射元数据**

JPA支持XML和[JDK](https://baike.baidu.com/item/JDK)5.0注解两种元数据的形式，元数据描述对象和表之间的映射关系，框架据此将实体[对象持久化](https://baike.baidu.com/item/%E5%AF%B9%E8%B1%A1%E6%8C%81%E4%B9%85%E5%8C%96)到数据库表中；

**API**

用来操作实体对象，执行CRUD操作，框架在后台替代我们完成所有的事情，开发者从繁琐的JDBC和SQL代码中解脱出来。

**查询语言**

这是持久化操作中很重要的一个方面，通过[面向对象](https://baike.baidu.com/item/%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1)而非面向数据库的查询语言查询数据，避免程序的SQL语句紧密耦合。

#### EJB概念

EJB是sun的JavaEE服务器端[组件模型](https://baike.baidu.com/item/%E7%BB%84%E4%BB%B6%E6%A8%A1%E5%9E%8B)，设计目标与核心应用是部署分布式应用程序。简单来说就是把已经编写好的程序（即：类）打包放在服务器上执行。凭借java跨平台的优势，用EJB技术部署的[分布式系统](https://baike.baidu.com/item/%E5%88%86%E5%B8%83%E5%BC%8F%E7%B3%BB%E7%BB%9F/4905336)可以不限于特定的平台。EJB (Enterprise [JavaBean](https://baike.baidu.com/item/JavaBean))是J2EE(javaEE)的一部分，定义了一个用于开发基于组件的企业多重应用程序的标准。其特点包括[网络服务](https://baike.baidu.com/item/%E7%BD%91%E7%BB%9C%E6%9C%8D%E5%8A%A1/9498645)中心支持和核心开发工具(SDK)。 在J2EE里，Enterprise Java Beans(EJB)称为Java 企业Bean，是Java的核心代码，分别是会话Bean（Session Bean），实体Bean（Entity Bean）和消息驱动Bean（MessageDriven Bean）。在EJB3.0推出以后，实体Bean被单独分了出来，形成了新的规范[JPA](https://baike.baidu.com/item/JPA)。

#### Hibernate的get()与load()的区别

![img](file:///C:\Users\DELL\AppData\Roaming\Tencent\Users\1355140243\QQ\WinTemp\RichOle\OVU63XT13@BDT{9RJD719NW.png)

当使用get()查询的数据不存在时，会正常执行，展示null值。

![img](file:///C:\Users\DELL\AppData\Roaming\Tencent\Users\1355140243\QQ\WinTemp\RichOle\V5E_APMRHAATL]VO{Y}$ZYI.png)

当使用load()进行查询的数据不存在时，会抛出异常，因此，不建议使用load方法。

#### lazy的使用

![a](C:\Users\DELL\Desktop\a.png)

使用get()方法获取数据时，lazy默认的时false，因此在箭头处直接执行sql语句进行查询![b](C:\Users\DELL\Desktop\b.png)

使用load()方法进行获取时，lazy默认为true，会在使用时才执行sql查询，进箭头处才会执行sql。

lazy属性时hibernate的一种优化策略，在必要时会节省数据库连接资源的开销。

lazy有三个属性：true、false、extra

【true】:默认取值，它的意思是只有在调用这个集合获取里面的元素对象时，才发出查询语句，加载其 
     集合元素的数据 

【false】:取消懒加载特性，即在加载对象的同时，就发出第二条查询语句加载其关联集合的数据 

【extra】:一种比较聪明的懒加载策略，即调用集合的size/contains等方法的时候，hibernate并不会去加载整个集合的数据，而是发出一条聪明的SQL语句，以便获得需要的值，只有在真正需要用到这些集合元素对象数据的时候，才去发出查询语句加载所有对象的数据。

#### 关联关系的几种方式

##### 1.maney-to-one

我们在多的一方配置单向的<money-to-one>

```java
       	<!--多的一方配置的属性与数据库的外键进行关系映射-->
          <!--name为实体中的关系，column为数据库中的参考外键-->
        <many-to-one name="people" column="pid"></many-to-one>
```

然后再代码出进行保存测试

```java
 People people=new People();
        people.setName("小王");
        people.setYear(20l);
        GoodsEntity goodsEntity=new GoodsEntity();
        goodsEntity.setGoodsName("瓜子");
        goodsEntity.setGoodsPrice(33);
        goodsEntity.setPeople(people);
        session.save(goodsEntity);
        transaction.commit();
```

按照逻辑应当先保存people，当不先进行people的保存时，运行程序会抛出如下异常

```java
java.lang.IllegalStateException: org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing: com.hibernate.pojo.People

	
Caused by: org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing: com.hibernate.pojo.People
	at org.hibernate.engine.internal.ForeignKeys.getEntityIdentifierIfNotUnsaved(ForeignKeys.java:350)
	at org.hibernate.type.EntityType.getIdentifier(EntityType.java:495)
	at org.hibernate.type.ManyToOneType.isDirty(ManyToOneType.java:332)
	at org.hibernate.type.ManyToOneType.isDirty(ManyToOneType.java:343)
	at org.hibernate.type.TypeHelper.findDirty(TypeHelper.java:315)

	at org.hibernate.internal.SessionImpl.doFlush(SessionImpl.java:1454)
	... 31 more
```

出现此种情况，我们再置文件中写上cascade属性设置为级联便可

```java
<!--多的一方配置的属性与数据库的外键进行关系映射-->
        <many-to-one name="people" column="pid" cascade="save-update"></many-to-one>
```

默认会先执行主表的插入操作，然后进行从表的插入操作。

##### 2.one-to-money

再一的一方中给实体类添加set集合，再一的配置文件中添加如下标签

```java
<set name="goodsEntities"><!-- 实体类中的属性名称-->
            <key>
                <column name="pid"></column><!--关联的外键的列名-->
            </key>
             <one-to-many class="com.hibernate.pojo.GoodsEntity"/><!--关联的实体类（多的一方）-->
        </set>
```

![3](C:\Users\DELL\Desktop\3.png)

看程序再关联查询中的结果，可知，在红线处打印了第二条sql，关联查询时采用的时懒加载。可以在set标签上配置lazy="false"，来关闭懒加载的属性。

在执行一对多的一的一方的保存时

![q1](C:\Users\DELL\Desktop\q1.png)

```
hibernate一共打印了五条数据，先执行主表的插入，然后执行从表的插入，再在从表的外键中建立主从表的关系维护，执行update语句。（此处主表数据一条，从表数据两条）
```

注：以上均为单向维护。

