package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 15. 二进制中1的个数
 *
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中1的个数。
 * 例如，把9表示成二进制是1001，有2位是1。因此，如果输入9，则该函数输出2。
 *
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 *
 * @author: cheng kai
 * @create: 2021-02-19 16:28
 **/
public class NumOneOfBinary {
    // you need to treat n as an unsigned value
    public static int solution(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("9 has " + solution(9) + " ones");
    }
}
