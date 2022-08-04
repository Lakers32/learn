package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 46. 把数字翻译成字符串
 * <p>
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * @author: cheng kai
 * @create: 2021-03-01 14:15
 **/
public class TranslateNumToStringTotal {

    /**
     * 动态规划 + 字符串遍历
     * 此题的动态规划计算是对称的，即从左向右遍历（从第dp[2]计算至dp[n]）和从右向左遍历（从第dp[n−2]计算至dp[0]）所得方案数一致。
     *
     * @param num
     * @return
     */
    public static int solution(int num) {
        String s = String.valueOf(num);
        // 当num第1,2位的组成的数字∈[10,25]时，显然应有2种翻译方法，即dp[2] = dp[1] + dp[0]，而显然dp[1] = 1，因此推出dp[0] = 1。类似这里的c = a + b。
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }

        return a;
    }

    /**
     * 动态规划 + 数字求余
     * 利用动态规划的对称性
     *
     * @param num
     * @return
     */
    public static int solution2(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }

        return a;
    }

    public static void main(String[] args) {
        int num = 12258;
        System.out.println("The total of translating num to string is " + solution2(num));
    }
}
