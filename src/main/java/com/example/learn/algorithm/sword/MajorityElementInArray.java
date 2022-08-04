package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 39. 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * @author: cheng kai
 * @create: 2021-02-24 11:36
 **/
public class MajorityElementInArray {

    /**
     * 本题常见的三种解法：
     * 哈希表统计法：遍历数组nums，用HashMap统计各数字的数量，即可找出众数。此方法时间和空间复杂度均为O(N)。
     * 数组排序法：将数组nums排序，数组中点的元素一定为众数。
     * 摩尔投票法：核心理念为票数正负抵消。此方法时间和空间复杂度分别为O(N)和O(1)，为本题的最佳解法。
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        // 验证x是否为众数
        for (int num : nums) {
            if (num == x) {
                count++;
            }
        }
        // 当无众数时返回0
        return count > nums.length / 2 ? x : 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println("Majority element in array is " + solution(nums));
    }
}
