package com.c;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 1.给定一个Excel表格中的列名称，返回其相应的列序号。
 *   二维数组i+j;
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 * 输入: "A"
 * 输出: 1
 *
 * 示例 2:
 * 输入: "AB"
 * 输出: 28
 *
 * 示例 3:
 * 输入: "ZY" Z=26*26+25   （26+25）*26 1 26+2 26*2+3 =1+28+55 26 + 26*25+25
 * 输出: 701
 */
public class Algrithm1 {


    public static void main(String[] args) {
        int zy = getOrder("AB");
        double x=get("AB");
        int ab = getOrder2("AB");
        System.out.println(x+"====="+zy+"===="+ab);
//        System.out.println(Math.pow(2,8));
    }

/**
 *
 *z y
 *   z*26(0)+y*26(1)
 *
 * 当时，
 *
 */
        public static double get(String str){
            String regex="[(a-zA-Z)]";
            char[] chars = str.toUpperCase().toCharArray();
            Integer a1 = Integer.valueOf(chars[0]);
                a1-=64;
            if(chars.length==1){
                return a1;
            }
            double sum=0;
            for (int i = 0; i <chars.length; i++) {
                if(!String.valueOf(chars[i]).matches(regex)){
                    throw new RuntimeException("输入非法的字符");
                }
                int i1 = Integer.valueOf(chars[chars.length-i-1]) - 64;
                int pow =(int) Math.pow(26, i);
                sum+=i1*pow;
            }
            return sum;
        }
    public static int getOrder2(String lieName){
        //将输入的字母串分割成为单个字符,将其转变为大写值
        char[] chars = lieName.toUpperCase().toCharArray();
        int number=0;
        for (int i = 0; i <chars.length ; i++) {
            if(chars.length==1){//第一位
                number=((Integer.valueOf(chars[i]))-64);
                break;
            }
            number+=(((Integer.valueOf(chars[i]))-64)*26);
        }
        return number;
    }



    public static int getOrder(String lieName){
        //将输入的字母串分割成为单个字符,将其转变为大写值
        char[] chars = lieName.toUpperCase().toCharArray();
        int number=0;
        for (int i = 0; i <chars.length ; i++) {
            if(i==chars.length-1){//最后一位
                number+=((Integer.valueOf(chars[i]))-64);
                break;
            }
            number+=(((Integer.valueOf(chars[i]))-64)*26);
        }
        return number;
    }

}
