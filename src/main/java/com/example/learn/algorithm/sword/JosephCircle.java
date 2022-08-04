package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 62. 圆圈中最后剩下的数字
 * <p>
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * @author: cheng kai
 * @create: 2021-03-06 11:07
 **/
public class JosephCircle {

    /**
     * 数学 + 递归
     *
     * @param n
     * @param m
     * @return
     */
    public static int solution(int n, int m) {
        return func(n, m);
    }

    public static int func(int n, int m) {
        if (n == 1) {
            return 0;
        }

        int x = func(n - 1, m);

        return (m + x) % n;
    }

    /**
     * 参考方法一，将递归改成迭代 (动态规划)
     *
     * @param n
     * @param m
     * @return
     */
    public static int solution2(int n, int m) {
        int x = 0;

        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }

        return x;
    }

    public static void main(String[] args) {
        int n = 5, m = 3;
        System.out.println("The last remaining value is " + solution(n, m));
    }
}
