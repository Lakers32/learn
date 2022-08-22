package com.example.learn.algorithm.leetcode;

/**
 * 长度最小的子数组
 * <p>
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 */
public class MinSubArrayLen {

    /**
     * 双指针滑动窗口
     **/
    public int solution(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int target = 7; int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println("minSubArrayLen is " + minSubArrayLen.solution(target, nums));
    }
}
