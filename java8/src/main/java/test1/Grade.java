package test1;

import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        System.out.println("输入成绩");
        String data = sc.nextLine().trim();
        int a = Integer.parseInt(data);
        test(a);

    }
    public static void test(int a){
        switch (Reference.reference(a)){
            case mid:
                System.out.println("中等");
                break;
            case noPass:
                System.out.println("不及格");
                break;
            case pass:
                System.out.println("及格");
                break;
            case pretty:
                System.out.println("良好");
                break;
            case excellent:
                System.out.println("优秀");
                break;
        }
    }
}
