package com.a.stream;

import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAPI {
    @Test
    public  void test1(){
        ArrayList arrayList=new ArrayList();
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("1");
        arrayList.add("6");
        arrayList.add("4");
        arrayList.stream().sorted().forEach(
                a->{
                    System.out.print(a);
                }
        );
        boolean b = arrayList.stream().anyMatch(Predicate.isEqual("1"));
        System.out.println(b);


    }
    @Test
    public void testDate(){
        LocalDate date=LocalDate.now();
        LocalTime localTime=LocalTime.now();
        LocalDateTime localDateTime=LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
//        LocalDate.parse(,"yyyy-MM-dd hh:mm:ss");
        System.out.println(date+"=="+localTime+"====="+localDateTime);
        System.out.println(format);
    }
    /*
	  	1.	给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
		，给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
	 */
    @Test
    public void test5(){
        Integer[] nums = new Integer[]{1,2,3,4,5};

        Arrays.stream(nums)
                .map((x) -> x * x)
                .forEach(System.out::println);
    }


    @Test
    public void test2(){
        List<String> list=new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.stream().map((s) -> s.toUpperCase()).forEach(s -> System.out.println(s));

    }
    @Test
    public void test3(){
        List<String> list=new ArrayList();
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("d");
        Optional<String> first = list.stream().sorted().findFirst();
        System.out.println(first.get());

    }
}
class Demo {
    public static String sRet = "";
    public static void func(int i)
    {
        try
        {
            if (i%2==0)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            sRet += "0";
            return;
        }
        finally
        {
            sRet += "1";
        }
        sRet += "2";
    }
    public static void main(String[] args)
    {
        func(1);
        func(2);
        System.out.println(sRet);
    }
}
