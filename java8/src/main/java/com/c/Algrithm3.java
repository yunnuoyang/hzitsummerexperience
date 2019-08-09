package com.c;

/**
 * 3. 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从1到n选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口guess(int num)，
 * 它会返回 3 个可能的结果（-1，1或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 *
 * 示例 :
 * 输入: n = 10, pick = 6
 * 输出: 6
 */
public class Algrithm3{
    public static void main(String[] args) {
        Integer integer = toGuess(10, 10);
        System.out.println(integer);

    }
    public static Integer toGuess(int n, int num){
        Guess<Integer> guess = new Guess<Integer>() {
            @Override
            public int guess(Integer num) {
                if (n > num) {
                    System.out.println("猜小了");
                    return lower;
                }
                if (n < num) {
                    System.out.println("猜大了");
                    return higer;
                }
                System.out.println("恭喜你，猜对了");
                return right;
            }
        };
        return guess.guess(num);
    }
}
interface Guess<T>{
    int lower=-1;
    int higer=1;
    int right=0;
    int guess(T num);
}
