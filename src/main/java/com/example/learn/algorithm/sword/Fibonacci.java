package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 10- I. 斐波那契数列，类似青蛙跳台阶问题(初始化条件可能不一样)
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0, F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由0和1开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @author: cheng kai
 * @create: 2021-02-09 15:45
 **/
public class Fibonacci {

    /**
     * 递归法
     * 大量重复的递归计算，n大于40之后效率极差
     *
     * @param n
     * @return
     */
    public static int solution(int n) {
        if (n < 0) {
            return -1;
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return (solution(n - 1) + solution(n - 2)) % 1000000007;
    }

    /**
     * 动态规划
     * 将第三个值计算出来之后，保留第三个值和第二个值
     *
     * @param n
     * @return
     */
    public static int solution2(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci(44) = " + solution(44));

        System.out.println("Fibonacci(44) = " + solution2(2));
    }
}
