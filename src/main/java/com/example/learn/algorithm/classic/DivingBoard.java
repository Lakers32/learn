package com.example.learn.algorithm.classic;

import java.util.Arrays;

/**
 * @description: 面试题 16.11. 跳水板
 * <p>
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * 返回的长度需要从小到大排列。
 * <p>
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * @author: cheng kai
 * @create: 2021-03-22 10:18
 **/
public class DivingBoard {

    public static int[] solution(int shorter, int longer, int k) {
        /**
         * 如果 k=0，则不能建造任何跳水板，因此返回空数组。
         */
        if (k == 0) {
            return new int[0];
        }

        /**
         * 如果 shorter 和 longer 相等，则建造的跳水板的长度是唯一的，都等于 shorter×k，因此返回长度为 1 的数组，数组中的元素为 shorter×k。
         */
        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        /**
         * 考虑一般情况，即 shorter<longer 且 k>0。
         * 由于短木板和长木板一共使用 k 块，因此一共有 k+1 种组合，每种组合下建造的跳水板长度都是不一样的，一共有 k+1 种不同的长度。
         * 创建长度为 k+1 的数组 lengths，对于 0 ≤ i ≤ k，令 lengths[i] = shorter × (k−i) + longer × i（差值为longer - shorter的等差数列）
         */
        int[] lengths = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lengths[i] = shorter * (k - i) + longer * i;
        }

        return lengths;
    }

    public static void main(String[] args) {
        int shorter = 1, longer = 2, k = 3;
        System.out.println("The all lengths are " + Arrays.toString(solution(shorter, longer, k)));
    }

}
