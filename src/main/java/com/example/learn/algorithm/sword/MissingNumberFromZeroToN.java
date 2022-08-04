package com.example.learn.algorithm.sword;

/**
 * @description: 0～n-1中缺失的数字
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * @author: cheng kai
 * @create: 2021-03-03 11:23
 **/
public class MissingNumberFromZeroToN {

    /**
     * 0到n的累加，相减缺失后1到n-1的累加，差就是缺失值
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        return 0;
    }

    /**
     * 后面一个数减去前面一个数，差值等于2时，中间就是缺失值
     *
     * @param nums
     * @return
     */
    public static int solution2(int[] nums) {
        return 0;
    }

    /**
     * 索引不等于索引值，则索引就是缺失值
     *
     * @param nums
     * @return
     */
    public static int solution3(int[] nums) {
        return 0;
    }


    /**
     * 排序数组中的搜索问题，首先想到 二分查找 解决
     * 假定缺失的数字等于 “右子数组的首位元素” 对应的索引，因此考虑使用二分法查找 “右子数组的首位元素” 验证
     *
     * @param nums
     * @return
     */
    public static int solution4(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 7, 8, 9};

        System.out.println("The missing number is " + solution4(nums));
    }
}
