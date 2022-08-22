package com.example.learn.algorithm.leetcode;

/**
 * 移除元素
 * <p>
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 链接：https://leetcode.cn/problems/remove-element
 */
public class RemoveElement {

    /**
     * 快慢指针
     *
     * @param nums
     * @param val
     * @return
     */
    public int solution(int[] nums, int val) {

        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            // 不等于val时同时移动，等于时只移动fastIndex
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }

        return slowIndex;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        RemoveElement removeElement = new RemoveElement();
        System.out.println("slowIndex = " + removeElement.solution(nums, val));
    }
}
