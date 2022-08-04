package com.example.learn.algorithm.sword;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 剑指 Offer 03. 数组中重复的数字
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * <p>
 * @author: cheng kai
 * @create: 2021-02-02 13:23
 **/
public class FindRepeatNumber {

    /**
     * 暴力遍历
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    /**
     * 复杂性分析
     * <p>
     * 时间复杂度：O(n)。
     * 遍历数组一遍。使用哈希集合（HashSet），添加元素的时间复杂度为 O(1)，故总的时间复杂度是 O(n)。
     * 空间复杂度：O(n)。不重复的每个元素都可能存入集合，因此占用 O(n) 额外空间。
     *
     * @param nums
     * @return
     */
    public static int solution2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    /**
     * 如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，
     * 所以思路是重头扫描数组，遇到下标为i的数字如果不是i的话，（假设为m),那么我们就拿与下标m的数字交换。在交换过程中，
     * 如果有重复的数字发生，那么终止返回ture
     *
     * @param nums
     * @return
     */
    public static int solution3(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = solution3(nums);

        System.out.println("the repeat number is " + repeatNumber);
    }
}
