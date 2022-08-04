package com.example.learn.algorithm.sword;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 56 - I. 数组中数字出现的次数
 * <p>
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @author: cheng kai
 * @create: 2021-03-04 11:48
 **/
public class TwoNumsOnlyAppearOnceInArray {

    public static int[] solution(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;

        // 1. 遍历异或
        for (int num : nums) {
            n ^= num;
        }

        // 2. 循环左移，计算 m，并将 m 作为两个数值的分离标志
        while ((n & m) == 0) {
            m <<= 1;
        }

        // 3. 遍历 nums 分组
        for (int num : nums) {
            // 4.1. 当 num & m != 0
            if ((num & m) != 0) {
                x ^= num;
            }
            // 4.2. 当 num & m == 0
            else {
                 y ^= num;
            }
        }

        // 5. 返回出现一次的数字
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 10, 4, 1, 4, 3, 3};

        System.out.println("The two nums only appear once are " + Arrays.toString(solution(nums)));
    }

}
