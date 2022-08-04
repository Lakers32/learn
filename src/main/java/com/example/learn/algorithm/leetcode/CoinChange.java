package com.example.learn.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Description: 322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * https://leetcode-cn.com/problems/coin-change/
 * @Author: kotchen
 * @Date: 2021/6/5 14:27
 * @Version: 1.0
 **/
public class CoinChange {

    /**
     * 记忆化搜索
     *
     * @param coins
     * @param amount
     * @return
     */
    public int solution(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        // 记忆
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;

        return count[rem - 1];
    }

    /**
     * 动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public int solution2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        CoinChange coinChange = new CoinChange();
        System.out.println("The min number of coins is " + coinChange.solution2(coins, amount));
    }

}