package com.b.linknode;

public class XSArray {
    public static void main(String[] args) {
        //创建原始的二维数组
        //0没有值，
        int initArray[][]=new int[11][11];
        initArray[1][2]=1;
        initArray[2][4]=2;
        //打印原始的二维数组
        for (int [] row:initArray){
            for (int item:row){
                System.out.print(item);
            }
            System.out.println();
        }
        //转化为二维稀疏数组
        int sum=0;//得到具有值的个数
        for (int i = 0; i <initArray.length ; i++) {
            for (int j = 0; j <initArray[i].length ; j++) {
                if(initArray[i][j]!=0){
                    sum++;
                }
            }
        }
        /**
         * 00000000000       11 11 2
         * 00100000000       1  2  1
         * 00002000000       2  4  2
         */
        System.out.println(sum);
        //2创建对应的稀疏数组
        int count=0;
        int [][] sparseArr=new int[sum+1][3];
        sparseArr[0][0]=initArray.length;
        sparseArr[0][1]=initArray.length;
        sparseArr[0][2]=sum;

        for (int i = 0; i <initArray.length ; i++) {
            for (int j = 0; j <initArray[i].length ; j++) {
                if(initArray[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;//第一列
                    sparseArr[count][1]=j;//第二列
                    sparseArr[count][2]=initArray[i][j];//第三列
                }
            }
        }
        //3.遍历稀疏数组
        for (int [] a:sparseArr){
            for (int b:a){
                System.out.print(b+"\t");
            }
            System.out.println();
        }
        //将稀疏数组转回原样
        int[][] toSparseArr=new int[sparseArr[0][0]][sparseArr[0][1]];
            for (int j = 1; j <sparseArr.length ; j++) {
                     toSparseArr[sparseArr[j][0]][sparseArr[j][1]]=sparseArr[j][2];

            }
        System.out.println("=======反转后===========");
        for(int[] a:toSparseArr){
            for(int b:a){
                System.out.print(b+"\t");
            }
            System.out.println();
        }

    }

}
