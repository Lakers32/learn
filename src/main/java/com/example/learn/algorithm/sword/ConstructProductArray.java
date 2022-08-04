package com.example.learn.algorithm.sword;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 66. 构建乘积数组
 * <p>
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 请注意，不能使用除法。
 * <p>
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * @author: cheng kai
 * @create: 2021-03-06 16:43
 **/
public class ConstructProductArray {

    /**
     * 本质就是两个dp数组，分别维护 i 左侧、右侧的乘积和
     *
     * @param a
     * @return
     */
    public static int[] solution(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }

        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        // 计算 B[i] 的 下三角 各元素的乘积，直接乘入 B[i]（维护i左侧的dp）
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        // 计算 B[i] 的 上三角 各元素的乘积，记为 tmp ，并乘入 B[i]（维护i右侧的dp）
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }

        return b;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println("The product array is " + Arrays.toString(solution(a)));
    }

}
