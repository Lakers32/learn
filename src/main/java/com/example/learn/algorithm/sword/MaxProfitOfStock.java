package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 63. 股票的最大利润
 * <p>
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * @author: cheng kai
 * @create: 2021-03-06 14:24
 **/
public class MaxProfitOfStock {

    /**
     * 动态规划
     * 类似数组中当前值与前面某个值的最大差值
     *
     * @param prices
     * @return
     */
    public static int solution(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;

        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] profit = {7,1,5,3,6,4};

        System.out.println("Max profit of stock is " + solution(profit));
    }

}
