package com.c;

import java.util.*;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 * 示例 1：
 * 输入：[2,1,2]
 * 输出：5
 *
 * 示例 2：
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 * 输入：[3,2,3,4]2，3，8，8，14，23
 * 输出：10
 * 对于第二种情况：两边之和大于第三边并且两边之差小于第三边。即a+b>c和|a-b|c,a+c>b,b+c>a
 * 要判断输入的三条边能否够成三角形，只需满足条件两边之和大于第三边即可
 */
public class Algrithm5 {
    public static void main(String[] args) {
//        int calculate = calculate(new int[]{2,2,1});
        int calculate = calculate(new int[]{2,3,8,8,14,23});
//        int calculate = calculate(new int[]{3,4,5});
        System.out.println(calculate);
        long a=12;
        float b=13;

    }




    public static void todo(Integer [] arr){
        for (int i = 0; i <arr.length ; i++) {
            Arrays.copyOf(arr,3);
        }
    }
   public static List<Integer[]> getThreeNum(Integer [] str){
        List<Integer[]> arr=new ArrayList<>();
       for (int i = 0; i <str.length ; i++) {
           for (int j = 0; j <str.length ; j++) {
               for (int k = 0; k <str.length ; k++) {
                   if(i!=j&&j!=k&&k!=i){
                       arr.add(new Integer[]{str[i],str[j],str[k]});
                   }
               }
           }
       }
        return arr;
   }



    /**适用于只有三个值的数组进行计算
     *
     *
     * @return
     */
    public static int calculate(int [] arr){
            if(arr.length<3){
                return 0;
            }
           //先进性排序
           Arrays.sort(arr);
           for (int i = arr.length-1; i >=2 ; i--) {
                if(arr[i]<arr[i-2]+arr[i-1]){
                    return arr[i]+arr[i-2]+arr[i-1];
                }
           }


          return 0;

    }

    /**
     * 先进行排序
     * @return
     */
    public static int[] sort(int[] arr){
        int temp=0;
        for (int i = 0; i <arr.length-1 ; i++) {
            if(arr[i]>arr[i+1]){
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        return arr;
    }

}
