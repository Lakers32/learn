package com.example.learn.algorithm.sword;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 45. 把数组排成最小的数
 * <p>
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * @author: cheng kai
 * @create: 2021-03-01 11:27
 **/
public class MakeArraySplicingMinNum {

    /**
     * 将数组转化成String，然后快排，最后拼装成数值返回
     *
     * @param nums
     * @return
     */
    public static String solution(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        fastSort(strings, 0, strings.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strings) {
            res.append(s);
        }
        return res.toString();
    }

    public static void fastSort(String[] strings, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        String tmp = strings[i];
        while (i < j) {
            while ((strings[j] + strings[left]).compareTo(strings[left] + strings[j]) >= 0 && i < j) {
                j--;
            }
            while ((strings[i] + strings[left]).compareTo(strings[left] + strings[i]) <= 0 && i < j) {
                i++;
            }
            tmp = strings[i];
            strings[i] = strings[j];
            strings[j] = tmp;
        }
        strings[i] = strings[left];
        strings[left] = tmp;
        fastSort(strings, left, i - 1);
        fastSort(strings, i + 1, right);
    }

    /**
     * 利用java内置函数
     *
     * @param nums
     * @return
     */
    public static String solution2(int[] nums) {
        String[] strings = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strings) {
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println("The splicing min num is " + solution(nums));
    }

}
