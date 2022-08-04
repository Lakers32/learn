package com.example.learn.algorithm.sword;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 60. n个骰子的点数
 * <p>
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * @author: cheng kai
 * @create: 2021-03-06 09:59
 **/
public class DicesProbability {

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static double[] solution(int n) {
        double a = 1.0 / 6.0;
        double[] dp = {a, a, a, a, a, a};
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }

        return dp;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println("The dices probability are " + Arrays.toString(solution(n)));
    }
}
