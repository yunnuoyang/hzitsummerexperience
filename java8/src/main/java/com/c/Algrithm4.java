package com.c;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["s","d","addcv"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 */
public class Algrithm4 {
    public static void main(String[] args) {
        String split = allContains(new String[]{"flighttttt","flightttt","flighttt","flighttttttt","flighttttttt"});
        System.out.println(split);
    }
    public static String allContains(String[] str){
        String min = min(str);
        char[] chars = min.toCharArray();//排序，获得最小值
        String aChar = "";
        int target=0;//用来记录i具体的值的索引，用来截取串
        for(int i=0;i<chars.length;i++){
             aChar+= String.valueOf(chars[i]).trim();
            for (int j = 0; j <str.length ; j++) {
                String s = str[j].substring(0, i+1);
                if(target==0&&j==str.length){//当j执行到最后一条数据，target任然没有更新时，证明无相同开头
                    return "";
                }
                //char数组的元素比对此串的所有数据，直到最后一条数据仍然相等，由相同前缀，target=i+1
                if(s.equals(aChar)&&aChar.equals(str[str.length-1].substring(0,i+1))){
                    target=i+1;
                }else break;
            }
        }
        String substring="";
        if(target>0){
            substring= String.valueOf(chars).substring(0, target);
        }
        return substring;
    }
    public static String min(String[] str){
        String min=str[0];
        for (int i = 0; i <str.length-1 ; i++) {
            if(str[i].length()<str[i+1].length()){
                min=str[i];
            }
        }
        return min;
    }

}