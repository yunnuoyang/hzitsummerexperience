package com.c;

import java.util.*;

/**

 给定两个数组，编写一个函数来计算它们的交集。

 示例 1:
 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2]

 示例 2:
 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出: [9,4]

 说明:
 输出结果中的每个元素一定是唯一的。
 我们可以不考虑输出结果的顺序。
 */
public class Algrithm2 {


    public static void main(String[] args) {
        Integer[] nums1={4,9,5};
        Integer [] nums2={9,4,9,8,4};
        Integer[] objects = (Integer[]) getFinal(nums1, nums2).toArray();
        System.out.println();
    }
    public static ArrayList<Integer> getFinal(Integer[] a,Integer[] b){
       ArrayList<Integer> arr=new ArrayList<>();
        Integer[] int1 = get(a);
        Integer[] int2 = get(b);
        for (int i = 0; i <int1.length; i++) {
            for (int j = 0; j <int2.length  ; j++) {
                if(int1[i]==int2[j]){
                    arr.add(int1[i]);
                }
            }
        }
        return arr;
    }
    public static Integer[] get(Integer[] nums){
        Set<Integer> set=new HashSet();
        for(Integer num:nums){
            set.add(num);
        }
        Integer[] integers = set.toArray(new Integer[set.size()]);
        return integers;
    }


}
