package com.example.learn.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * <p>
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 */
public class Intersection {

    /**
     * 哈希法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] solution(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }

        //遍历数组2的过程中判断哈希表中是否存在该元素，如果存在 放到resSet中
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }

        int[] resArr = new int[resSet.size()];
        int index = 0;
        //将结果几何转为数组
        for (int i : resSet) {
            resArr[index++] = i;
        }

        return resArr;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        System.out.println("Intersection is" + intersection.solution(nums1, nums2));
    }

}
