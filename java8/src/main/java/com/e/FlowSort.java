package com.e;

/**
 * 冒泡排序
 */
public class FlowSort {
    public static void main(String[] args) {
        int[] arr ={3,43,63,7,68,7};
        for (int i = 0; i <arr.length; i++) {
            int temp;
            for (int j = 0; j <i ; j++) {
                if(arr[i]<arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println(arr);
        System.out.println(arr);

    }

}
