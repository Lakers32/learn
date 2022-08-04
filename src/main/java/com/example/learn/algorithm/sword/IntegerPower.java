package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 16. 数值的整数次方
 * <p>
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * @author: cheng kai
 * @create: 2021-02-19 17:01
 **/
public class IntegerPower {
    public static double solution(double x, int n) {
        if (x == 0) {
            return 0;
        }

        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println("10个2.00000相乘等于" + solution(2.00000, 10));
//        System.out.println("3个2.10000相乘等于" + solution(2.10000, 3));
        System.out.println("-2个2.00000相乘等于" + solution(2.00000, -2));
    }
}
