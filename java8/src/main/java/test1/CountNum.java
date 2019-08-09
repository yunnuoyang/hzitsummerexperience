package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2+22+222+2222+22222
 * 2   2*10^0+2
 * 22  2*10^1+2
 * 222 2*10^2+2*10^1+2
 * 2222
 * 这个算法不考虑大整数相加的情况，观察这个算法的规律，
 * 会发现每一项都是由n个1表示，那么怎么用n来表示第n项呢，
 * 这样的话循环相加就可以解决问题了，这里有一个式子：
 * （10的n次方-1）/9 （至于怎么来的就去看高中时候的通项公式的求法），
 * 这个式子一出来，那么接下来就简单了，主要函数如下：
 * int SumData(int n){
 *
 *       if(n==1)
 *
 *           return 1;
 *
 *       else
 *
 *  return (int)(math.Pow(10,n)-1)/9 +SumData(n-1);
 */
public class CountNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入所需要目标数字");
        String num = sc.nextLine();
        System.out.println("请输入次数");
        String count = sc.nextLine();
        int i = countNum(Integer.parseInt(num), Integer.parseInt(count));
        System.out.println("计算结果为"+i);
        System.out.println(SumData(5)*2);

    }

    /**
     * （10的n次方-1）/9 （至于怎么来的就去看高中时候的通项公式的求法），
     * @param n
     * @return
     */
    public static int SumData(int n){
        if(n==1)
            return 1;
        else
            return (int)(Math.pow(10,n)-1)/9 +SumData(n-1);
    }

    /**
     * 看作一个直角三角形
     * @param num
     * @param count
     * @return
     */
    public static int countNum(int num,int count){
        String str="";
        List<String> list=new ArrayList();
        for(int i=1;i<=count;i++){
            for(int j=count;j>=i;j--){
                str+=num;
            }
            list.add(str);
            str="";
        }
        int result=0;
        for (int i = 0; i <list.size() ; i++) {
            String o = list.get(i);
            result+=Integer.parseInt(o);
        }
        return result;

    }
}
class FromNet{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入1-9之间的数字：");
        int num=scanner.nextInt();
        System.out.println("请输入相加的个数：");
        int addNum=scanner.nextInt();

        int firstNum =num;//定义用户输入的数，判断0-9范围内
        int sum=0;//求和
        if (num>0&&num<10) {
            System.out.println(num+" ");

            for (int i = 1; i < addNum; i++) {//循环从第二个数开始
                num=firstNum+num*10;        //从第二个数开始到最后一个数
                sum+=num;                    //从第二个数开始累加的和
                System.out.println(num+" ");

            }
            System.out.println("的和是："+(sum+firstNum));//再把第一个数加上
        }else{
            System.out.println("请输入0-9的数字");
        }
    }

}

class One{
    /**
     * 1. 利用条件运算符的嵌套完成对应成绩等级的输出。大于等于90为A,60到89为B,小于60为C.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("输入成绩，查看您的等级");
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        int i = Integer.parseInt(s);
        String grade = getGrade(i);
        System.out.println("等级："+grade);
    }
    public static String getGrade(int i){
        return i>=90?"A":((89>i&&i>=60)?"B":"C");
    }
}