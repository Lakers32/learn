package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 17.04. 消失的数字
 * <p>
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * <p>
 * https://leetcode-cn.com/problems/missing-number-lcci/
 * @author: cheng kai
 * @create: 2021-03-22 14:05
 **/
public class MissingNumberInArray {

    /**
     * 异或法
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;

        return res;
    }

    /**
     * 累加法
     *
     * @param nums
     * @return
     */
    public static int solution2(int[] nums) {
        int arraySum = 0, nSum = 0;
        for (int i = 0; i < nums.length; i++) {
            arraySum += nums[i];
            nSum += i;
        }
        nSum += nums.length;

        return nSum - arraySum;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 0, 1};
        System.out.println("The missing num is " + solution(nums1));

        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("The missing num is " + solution2(nums2));
    }

}
