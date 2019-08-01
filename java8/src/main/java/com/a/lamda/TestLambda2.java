package com.a.lamda;

import org.junit.Test;
public class TestLambda2 {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 321
     * 456
     * 879
     * 123
     * 456
     * 789
     */
    @Test
    public void test1(){
        int a[][] ={{3,2,1},{4,5,6},{8,7,9}};
        int s=3;
//        int[][] sort = sort(a);
    }

    public static void main(String[] args) {
        String name = "顺顺";

        f1(name);
        f2(name);
    }

    private static void f2(String name) {
        name = "丰丰";
        f1(name);
    }

    static void   f1(String name){
        System.out.println(name);
    }

}
