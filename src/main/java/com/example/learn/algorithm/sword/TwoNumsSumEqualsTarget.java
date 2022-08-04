package com.example.learn.algorithm.sword;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 57. 和为s的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * @author: cheng kai
 * @create: 2021-03-04 16:18
 **/
public class TwoNumsSumEqualsTarget {

    /**
     * 双指针
     * 两个int相加，可能会超过int，可以考虑有target减去其中一个
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println("The two nums equals target are " + Arrays.toString(solution(nums, target)));
    }

}
