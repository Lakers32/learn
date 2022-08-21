package com.example.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 * <p>
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * 链接：https://leetcode.cn/problems/4sum-ii
 */
public class FourSumCount {

    public int solution(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();

        // AB集合相加
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }

        // CD集合相加取反
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FourSumCount fourSumCount = new FourSumCount();

        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};
        System.out.println("The match number is " + fourSumCount.solution(nums1, nums2, nums3, nums4));
    }

}
