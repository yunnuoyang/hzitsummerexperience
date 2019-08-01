package test1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class Test1 {
    public void test1(){

    }



    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    @Test
    public void test2(){
        StringBuffer str=new StringBuffer();
        str.append("a  b c");
        String a = a(str);
        System.out.println(a);

    }

    public String a(StringBuffer str){

        String s1 = str.toString();
        //记录串的长度
        int length = s1.length();
        char[] chars = s1.toCharArray();
        StringBuffer sbf=new StringBuffer();
        for (int i = 0; i <length ; i++) {
            String s = String.valueOf(chars[i]);
            if(s.trim().length()==0){
                sbf.append("%20");
                continue;

            }
            sbf.append(chars[i]);
        }
        return sbf.toString();
    }

    /***
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    @Test
    public void test3(){
        int a = 0;
        int[][] arr = {{6,1,2},{3,5,4},{9,8,7},{10,11,12}};
        boolean b = find(2, arr);
        System.out.println(b);
    }
    public boolean find(int target, int [][] array) {



        //求出一位数组的长度
        int length = array[0].length;
        //二位数组的长度
        int alllen = array.length;
        //i是外层，j是内层
        int temp=0;
        //将所有的二维数组的值放入一个一维数组
        int a[][]=new int[alllen][length];
        for (int i = 0; i <alllen ; i++) {
            //对横行进行排序
            sort(array[i],array[i].length);
        }
        for (int i = 0; i <alllen-1 ; i++) {
            int t=0;
            for (int j = 0; j <length ; j++) {
                if(array[i][j]>array[i+1][j]){
                    t=array[i][j];
                    array[i][j]=array[i+1][j];
                    array[i+1][j]=t;
                }
            }
        }
        for (int i = 0; i <alllen ; i++) {
            for (int j = 0; j <length ; j++) {
                if(array[i][j]==target){
                   return true;
                }
            }
        }
        return false;
    }

    /**
     * 冒泡排序
     * @param arr
     * @param n
     */
    public void sort(int arr[],int n){
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {        //此处你可能会疑问的j<n-i-1，因为冒泡是把每轮循环中较大的数飘到后面，
                // 数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
                if (arr[j] > arr[j + 1]) {        //即这两个相邻的数是逆序的，交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;//没有数据交换，数组已经有序，退出排序
        }
    }
    @Test
    public void print(){
        ListNode listNode1=new ListNode(3);
        ListNode listNode2 = new ListNode(0);
        listNode1.next=listNode2;
        listNode2.next=new ListNode(5);
        printListFromTailToHead(listNode1);
//        intListFromTailToHead(listNode1);
    }

    /**
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        int[] a=new int[30];
        int index=0;
        ArrayList<Integer> arrayList=null;
        while(listNode!=null){
            a[index]=listNode.val;
            listNode= listNode.next;
            index++;
        }
        arrayList=new ArrayList();
        for (int i = index-1; i >=0 ; i--) {

                arrayList.add(a[i]);
        }
        return arrayList;
    }
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> intListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> arrayList=new ArrayList<>();
        String[] sbf=new String[1024];
        int index=0;
        while(listNode!=null){
            int val = listNode.val;
            if(val!=0){
                sbf[index]=String.valueOf(val);
            }else if(val==0){
                sbf[index]="0";
                index++;
                continue;
            }
            listNode= listNode.next;
            index++;
        }
        for (int i = index; i >-0 ; i--) {
            arrayList.add(Integer.parseInt(sbf[i]));
        }
        return arrayList;
    }


        public ArrayList<Integer> prtListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> arrayList = null;
            Stack<Integer> stack = new Stack();
            while (listNode != null) {
                stack.push(listNode.val);
                listNode = listNode.next;
            }
            arrayList = new ArrayList();
            while (!stack.empty()) {
                arrayList.add(stack.pop());
            }
            return arrayList;
        }

    /**
     * 递归版本
     */
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
        public ArrayList<Integer> rintListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.rintListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
