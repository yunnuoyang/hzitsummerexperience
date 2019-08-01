package test1;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

/**
 * 反转输出
 */
public class InversOut {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入数据进行反转");
        String data = sc.nextLine().trim();
        int a = Integer.parseInt(data);
        int[] temp=new int[10];
        for (int i=0;i<temp.length-1;i++){
            if(i==0){
                temp[i]= a%10;
            }
            a= get(a);
            temp[i+1]= a%10;
        }
        System.out.println("反转输出");
        for(int j=0;j<temp.length;j++){
            if(temp[j]!=0){

                System.out.print(temp[j]);
            }
        }
    }
    public static int get(int a){
        a=a/10;
        return a;
    }
    @Test
   public void testStack(){
       Stack  stack=new Stack();
       stack.push(1);
       stack.push(2);
       stack.push(3);
       stack.push(4);
       while (!stack.empty()){
           Object pop = stack.pop();
           System.out.println(pop);
       }
   }
}
