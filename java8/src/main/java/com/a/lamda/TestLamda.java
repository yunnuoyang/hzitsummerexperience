package com.a.lamda;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;

public class TestLamda {
    @Test
    public void testCompare(){
        Comparator<Integer> com=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> treeSet=new TreeSet<>(com);
        treeSet.add(3);
        treeSet.add(8);
        treeSet.add(133);
        treeSet.add(5);
        //按照从小到大进行排序，通过实现了Comparator接口
        //输出3，5，8，133
        for(Integer i:treeSet){
            System.out.println(i);
        }
    }
    @Test
    public void testLambdaComparator(){
        Comparator<Integer> com=(x,y)->Integer.compare(x,y);
        TreeSet<Integer> treeSet=new TreeSet<>(com);
        treeSet.add(3);
        treeSet.add(8);
        treeSet.add(133);
        treeSet.add(5);
        //按照从小到大进行排序，通过实现了Comparator接口
        //输出3，5，8，133
        for(Integer i:treeSet){
            System.out.println(i);
        }
    }
    @Test
    public void testIndentiti(){
       CompareByMe compareByMe= new CompareByMe<Integer,Integer>(){
            public boolean test(Integer int1,Integer int2) {
                return int1>int2;
            }
        };
        //可以比较大小
       int a=8;
       int b=7;
        System.out.println(compareByMe.test(a,b));
    }
    @Test
    public void test(){
        List list=new ArrayList();
        list.add(2);
        list.add(24);
        list.add(23);
        list.forEach(System.out::println);
    }

    /**
     * Stream API
     */
    @Test
    public void test1(){
        List<Employe> employes=new ArrayList<>();
        employes.add(new Employe("张三",88.2));
        employes.add(new Employe("li",93.4));
        employes.add(new Employe("王五",99.2));
        employes.add(new Employe("赵六233421",100.9));
        employes.add(new Employe("天气",333.3));
        employes.stream()
                .filter(employe -> employe.getSalary()>90)
                .filter(employe -> employe.getName().length()>4)
                .limit(3)
                .forEach(System.out::println);
//        employes.stream().map().collect()
    }
    @Test
    public void test2(){
        Consumer consumer=(x)-> System.out.println(x);
        consumer.accept("大家好啊");
    }
    @Test
    public void test3(){
        Comparator<Integer> com=(x,y)->Integer.compare(x,y);
        int compare = com.compare(3, 2);
        /*Integer中的比较的源代码
        public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
        }
         */
        System.out.println(compare);
    }
    @Test
    public void test4(){
//        WebApplicationContext
//                ApplicationContext
        Runnable runnable=()->{
            System.out.println("执行run方法");
        };
        Thread thread=new Thread(()->{
            System.out.println("执行run方法");
        });
        thread.start();
    }

    /**
     * 对一个数进行操作
     */
    @Test
    public  void test5(){
        Integer operater = operater(3, (x) -> x * x);
        System.out.println(operater);
    }
    public Integer operater(Integer a,MyFun myFun){
        return myFun.getValue(a);
    }
}
