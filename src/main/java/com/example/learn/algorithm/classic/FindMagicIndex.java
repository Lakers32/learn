package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 08.03. 魔术索引
 * <p>
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 链接：https://leetcode-cn.com/problems/magic-index-lcci
 * @author: cheng kai
 * @create: 2021-03-19 20:03
 **/
public class FindMagicIndex {

    /**
     * 二分剪枝
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    /**
     * 减枝策略
     * 1、每次我们选择数组的中间元素，如果当前中间元素是满足条件的答案，那么这个位置往后的元素我们都不再考虑，只要寻找左半部分是否有满足条件的答案即可。
     * 2、否则我们需要查看左半部分是否有满足条件的答案，如果没有的话我们仍然需要在右半边寻找，使用的策略同上。
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (right - left) / 2 + left;
        // 左半部分
        int leftAnswer = getAnswer(nums, left, mid - 1);
        // 正常返回
        if (leftAnswer != -1) {
            return leftAnswer;
        }
        else if (nums[mid] == mid) {
            return mid;
        }
        // 右半部分
        return getAnswer(nums, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 5};
        System.out.println("The magic index of nums is " + solution(nums));

        int[] nums2 = {-1, 1, 2, 4, 4, 4, 6};
        System.out.println("The magic index of nums2 is " + solution(nums2));

        int[] nums3 = {-1, 0, 1, 2, 3};
        System.out.println("The magic index of nums3 is " + solution(nums3));
    }

}
