package com.example.learn.algorithm.sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 剑指 Offer 61. 扑克牌中的顺子
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * @author: cheng kai
 * @create: 2021-03-06 10:08
 **/
public class IsStraightInPoker {

    /*
    根据题意，此 5 张牌是顺子的 充分条件 如下：
    1、除大小王外，所有牌 无重复 ；
    2、设此 5 张牌中最大的牌为 max ，最小的牌为 min （大小王除外），则需满足：
       max - min < 5
    */

    /**
     * 集合 Set + 遍历
     *
     * @param nums
     * @return
     */
    public static boolean solution(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;

        for (int num : nums) {
            // 跳过大小王
            if (num == 0) {
                continue;
            }
            // 最大牌
            max = Math.max(max, num);
            // 最小牌
            min = Math.min(min, num);
            // 若有重复，提前返回 false
            if (repeat.contains(num)) {
                return false;
            }
            // 添加此牌至 Set
            repeat.add(num);
        }

        // 最大牌 - 最小牌 < 5 则可构成顺子
        return max - min < 5;
    }

    /**
     * 排序 + 遍历
     *
     * @param nums
     * @return
     */
    public static boolean solution2(int[] nums) {
        int joker = 0;
        // 数组排序
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            // 统计大小王数量
            if (nums[i] == 0) {
                joker++;
            }
            // 若有重复，提前返回 false
            else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }

        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nums[joker] < 5;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Is nums straight? " + solution(nums));

        int[] nums2 = {0, 0, 1, 2, 5};
        System.out.println("Is nums2 straight? " + solution(nums2));
    }
}
