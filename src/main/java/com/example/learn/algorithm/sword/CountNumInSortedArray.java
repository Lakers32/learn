package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @author: cheng kai
 * @create: 2021-03-03 10:29
 **/
public class CountNumInSortedArray {

    /**
     * 二分查找
     * 先确定右侧位置，再确定左侧位置
     * 移动过程中是否等于target判断难懂
     *
     * @param nums
     * @param target
     * @return
     */
    public static int solution(int[] nums, int target) {
        // 搜索右边界 right (i 出界即为 right)
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if (j >= 0 && nums[j] != target) {
            return 0;
        }

        // 搜索左边界 right (j 出界即为 left)
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;

        return right - left - 1;
    }

    /**
     * 以上代码solution 显得比较臃肿（两轮二分查找代码冗余）。为简化代码，可将二分查找右边界 right 的代码 封装至函数 helper()
     *
     * @param nums
     * @param target
     * @return
     */
    public static int solution2(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    private static int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        System.out.println("Target " + target + " occurs " + solution2(nums, target) + " times");
    }
}
