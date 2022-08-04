package com.example.learn.algorithm.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 剑指 Offer 57 - II. 和为s的连续正数序列
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * @author: cheng kai
 * @create: 2021-03-04 17:31
 **/
public class ContinuousSequenceSumEqualsTarget {

    /**
     * 求和公式
     *
     * @param target
     * @return
     */
    public static int[][] solution(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> sequenceList = new ArrayList<>();

        while (i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if (j == (int) j) {
                int[] ans = new int[(int) j - i + 1];
                for (int k = i; k <= (int) j; k++) {
                    ans[k - i] = k;
                }
                sequenceList.add(ans);
            }
            i++;
        }

        return sequenceList.toArray(new int[0][]);
    }

    /**
     * 滑动窗口（双指针）
     *
     * @param target
     * @return
     */
    public static int[][] solution2(int target) {
        int i = 1, j = 2, sum = 3;
        List<int[]> sequenceList = new ArrayList<>();

        while(i < j) {
            if(sum == target) {
                int[] ans = new int[j - i + 1];
                for(int k = i; k <= j; k++) {
                    ans[k - i] = k;
                }
                sequenceList.add(ans);
            }
            if(sum >= target) {
                sum -= i;
                i++;
            } else {
                j++;
                sum += j;
            }
        }

        return sequenceList.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int target = 15;

        int[][] continuousSequence = solution2(target);
        System.out.println("The continuous sequence sum equals target are " );
    }
}
