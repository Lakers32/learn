package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 05.01. 插入
 * <p>
 * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。
 * <p>
 * 链接：https://leetcode-cn.com/problems/insert-into-bits-lcci
 * @author: cheng kai
 * @create: 2021-03-18 19:44
 **/
public class InsertBits {

    public static int solution(int N, int M, int i, int j) {
        int mask = ((1 << (j - i + 1)) - 1) << i;
        mask = ~mask;
        N &= mask;
        M = M << i;
        return M | N;
    }

    public static void main(String[] args) {
        int N = 1024, M = 19, i = 2, j = 6;

        System.out.println("The new num is " + solution(N, M, i, j));
    }
}
