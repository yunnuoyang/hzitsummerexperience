package test1;

import java.util.Scanner;

public class OneWork {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入0-99999的数据");
        String data = sc.nextLine().trim();
        int a = Integer.parseInt(data);
        int index=1;
        while(1==1){
            if(a<=10){
                break;
            }
            a= getInt(a);
            index++;
            if(a<=10){
                break;
            }
        }
        System.out.println(index);

    }
    public static int getInt(int num){
        num= num/10;
        return num;
    }


}
