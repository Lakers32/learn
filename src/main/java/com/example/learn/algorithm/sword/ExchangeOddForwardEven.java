package com.example.learn.algorithm.sword;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @author: cheng kai
 * @create: 2021-02-20 16:29
 **/
public class ExchangeOddForwardEven {

    /**
     * 第一次遍历找出奇数和偶数，再分别遍历重新拼装成数组
     * 很明显，多次遍历占用较多额外空间
     *
     * @param nums
     * @return
     */
    public static int[] solution(int[] nums) {
        int[] odds = new int[nums.length], evens = new int[nums.length];
        int oddIndex = 0, evenIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                odds[oddIndex++] = nums[i];
            } else {
                evens[evenIndex++] = nums[i];
            }
        }

        int[] exchangedNums = new int[nums.length];
        int exchangedIndex = 0;
        for (int i = 0; i < oddIndex; i++) {
            exchangedNums[exchangedIndex++] = odds[i];
        }
        for (int i = 0; i < evenIndex; i++) {
            exchangedNums[exchangedIndex++] = evens[i];
        }

        return exchangedNums;
    }

    /**
     * 首尾双指针
     *
     * @param nums
     * @return
     */
    public static int[] solution2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // left向左扫描，直到遇到偶数停下下
            if ((nums[left] & 1) == 1) {
                left++;
                continue;
            }
            // right向右扫描，直到遇到奇数停下来
            if (((nums[right]) & 1) == 0) {
                right--;
                continue;
            }
            swap(nums, left++, right--);
        }

        return nums;
    }

    /**
     * 快慢双指针
     *
     * @param nums
     * @return
     */
    public static int[] solution3(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if ((nums[j] & 1) == 1) {
                if (i != j) {
                    swap(nums, i, j);
                }
                i++;
            }
            j++;
        }
        return nums;
    }

    private static void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println("The exchange answer is " + Arrays.toString(solution(nums)));

        int[] nums2 = {1, 2, 3, 4, 5, 6};
        System.out.println("The exchange answer is " + Arrays.toString(solution2(nums2)));

        int[] nums3 = {9,9,14,1,2,12,8,14,7,20};
        System.out.println("The exchange answer is " + Arrays.toString(solution3(nums3)));
    }
}
