package test1;

import org.junit.Test;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        Integer pop = stack1.pop();
        stack2.push(pop);
    }

    public int pop() {
       return stack2.pop();
    }
    @Test
    public void test(){
        int i = JumpFloor(2);
        System.out.println(i);
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        //拿出数组的第一个元素
        int i = array[0];
        int temp=0;
        for (int j = 1; j <array.length ; j++) {
            if(i>array[j]){
                i=array[j];
            }
            if(j==array.length-1){
                return i;
            }
        }
        return 0;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        int index=0;
        for (int i = 0; i <target ; i++) {
            if(target==1){
                return 1;
            }
            if (target%2==1){
                index++;
            }if (target%2==0){
                index++;
            }
            index++;
        }
        return index;
    }


    /**
     * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
     *
     * 并且小Q对于能否被3整除这个性质很感兴趣。
     * 2,5
     *3
     * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
     *  12, 123, 1234, 12345...
     * 其中12, 123, 12345能被3整除。
     *输入两个数值
     */
    public static  int caculate(int start,int end){

        if(start>end){
            System.out.println(0);
            return 0;
        }
        int count = 0;
        for(long i = start;i<=end;i++){
            long r = ((1+i)*i/2)%3;
            if(r==0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int caculate = caculate(10, 110);
        System.out.println(caculate);
    }
}
