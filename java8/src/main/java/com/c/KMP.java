package com.c;

import java.io.Serializable;
import java.util.Arrays;

public class KMP{
    public static void main(String[] args) {
        int[] aas = kmpNext("AAAB");
        System.out.println(Arrays.toString(aas));
    }

    /**
     *
     * @param str1 源字符串
     * @param str2 字串
     * @param next 部分匹配表，是字串对应的部分匹配表
     * @return 如果是-1就是没有匹配到，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1,String str2,int[] next){

        //遍历
        for (int i = 0,j=0; i <str1.length() ; i++) {
           while (j>0&&str1.charAt(i)!=str2.charAt(j)){
               j=next[j-1];
           }

            if(str1.charAt(i)==str2.charAt(j)){
               j++;
           }
           if(j==str2.length()){
               //找到了
               return i-j+1;
           }
        }

        return -1;
    }

    /**
     * 创建一个字符串（字串）的部分匹配表
     * @param dest
     * @return
     */
    public static  int[] kmpNext(String dest){
            //创建一个next数组，保存部分匹配值
        int[] next=new int[dest.length()];
        next[0]=0;
        for(int i=1,j=0;i<dest.length();i++){
//当dest.charAt(i)!=dest.charAt(j),我们需要从next[j-1]获取新的j
            //直到我们发现有dest.charAt(i)==dest.charAt(j)才推出
            while(j>0&&dest.charAt(i)!=dest.charAt(j)){
            //这是kem算法的核心
               j=next[j-1];
           }

            //满足时，部分匹配值就是要+1
            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }

            next[i]=j;
        }
        return next;
    }
}
