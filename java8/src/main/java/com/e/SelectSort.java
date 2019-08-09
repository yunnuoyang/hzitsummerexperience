package com.e;

/**
 * 选择排序
 * 选择排序（Selection sort）是一种简单直观的排序算法。
 * 它的工作原理是：第一次从待排序的数据元素中选出最小（或最大）的一个元素，
 * 存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小（大）元素，
 * 然后放到已排序的序列的末尾。
 * 以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。
 */
public class SelectSort {
    public static void main(String[] args) {
        sort2();
//        sort(new int[]{1,24,523,5,34,65,12,87});
    }
    public static int[] sort(int[] arr){
        int min;
        int max;
        int count=arr.length;
        for (int i = 0; i <count ; i++) {
            min=i;//初始化最小下标
            max=count-1;//初始化最大下标
            //每次在剩余的数组中查找出数值最大与最小的下标值
            for (int j = i; j <count ; j++) {
                if(arr[min]>=arr[j]){//找出最小的下标
                    min=j;
                }
                if(arr[max]<=arr[j]){
                    max=j;//找出最大的下标
                }
            }
            //找出的剩余元素中的下标的值与初始赋值不相等
            //证明查找出了最小的元素，将最小的
            if(min!=i){
                int temp;
                temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
            //如果最大的值的下标不等于未排序的数列的最后一个值
            if(max!=count-1){
                //如果最大的下标等于当前循环的下标
                //即本次数组的最小值等于未排序数列的最大值
                //将最小的与最大的位置互换
                if(max == i){
                    int temp = arr[min];
                    arr[min] = arr[count - 1];
                    arr[count - 1] = temp;
                }else{
                    int temp = arr[max];
                    arr[max] = arr[count - 1];
                    arr[count - 1] = temp;
                }

            }
            count--;

        }
        System.out.println(arr);
        System.out.println(arr);
        return null;
    }

    /**
     * 找出最小的元素的下标然后进行替换排序
     */
    public static void sort2(){
       int[] arr={2,3,1,25,6,56,7,};
        for (int i = 0; i <arr.length ; i++) {
            int index=i;
            for (int j =index+1; j <arr.length ; j++) {
                if(arr[index]>arr[j]){
                    index=j;//找出最小的下标
                }
            }
            int temp=arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
        }
        System.out.println(arr);
    }
}
