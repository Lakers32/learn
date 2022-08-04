package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 16.07. 最大数值
 * <p>
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * <p>
 * https://leetcode-cn.com/problems/maximum-lcci/
 * @author: cheng kai
 * @create: 2021-03-22 09:24
 **/
public class MaxNum {

    /**
     * 1、首先 a - b 得到差值x
     * 2、由于是long型，右移63位得到符号位，注意负号不变，那么正数右移63位就是0，负数右移63位就是-1
     * 3、那么得出我们的计算公式 (1 + k) * a - b * k
     * **3.1、当 x >= 0 的时候，k = 0, 即 a > b
     * *******那么我们的计算公式为 1 * a - b * 0 = a
     * **3.2、当 x < 0的时候，k = -1, 即 b > a
     * *******那么我们的计算公式为 0 * a - b * ( -1 ) = b
     *
     * @param a
     * @param b
     * @return
     */
    public static int solution(int a, int b) {
        long x = (long) a - (long) b;
        int k = (int) (x >> 63);

        return (1 + k) * a - b * k;
    }

    /**
     * 不用转long
     *
     * @param a
     * @param b
     * @return
     */
    public int solution2(int a, int b) {
        // 先考虑没有溢出时的情况，计算 b - a 的最高位，依照题目所给提示 k = 1 时 a > b，即 b - a 为负
        int k = b - a >>> 31;
        // 再考虑 a b 异号的情况，此时无脑选是正号的数字
        int aSign = a >>> 31, bSign = b >>> 31;
        // diff = 0 时同号，diff = 1 时异号
        int diff = aSign ^ bSign;
        // 在异号，即 diff = 1 时，使之前算出的 k 无效，只考虑两个数字的正负关系
        k = k & (diff ^ 1) | bSign & diff;

        return a * k + b * (k ^ 1);
    }


    public static void main(String[] args) {
        int a = 2, b = 3;
        System.out.println("The max num is " + solution(a, b));
    }
}
