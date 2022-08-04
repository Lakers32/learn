package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * <p>
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * @author: cheng kai
 * @create: 2021-03-04 15:23
 **/
public class NumOnlyAppearsOnceInArray {

    /**
     * 位运算 + 有限状态自动机
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }

        return ones;
    }

    /**
     * 遍历统计
     *
     * @param nums
     * @return
     */
    public static int solution2(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int val = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            val <<= 1;
            val |= counts[31 - i] % m;
        }

        return val;
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, 7, 9, 7, 9, 7};

        System.out.println("The num only appear once is " + solution(nums));
    }

}
