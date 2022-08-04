package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 08.01. 三步问题
 * <p>
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * <p>
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * @author: cheng kai
 * @create: 2021-03-19 19:40
 **/
public class WaysToStep {

    public static int solution(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }

        int dp1 = 1, dp2 = 2, dp3 = 4, dp4 = 0;
        for (int i = 4; i < n + 1; i++) {
            //取模，对两个较大的数之和取模再对整体取模，防止越界（这里也是有讲究的）
            //假如对三个dp[i-n]都 % 1000000007，那么也是会出现越界情况（导致溢出变为负数的问题）
            //因为如果本来三个dp[i-n]都接近 1000000007 那么取模后仍然不变，但三个相加则溢出
            //但对两个较大的dp[i-n]:dp[i-2],dp[i-3]之和mod 1000000007，那么这两个较大的数相加大于 1000000007但又不溢出
            //取模后变成一个很小的数，与dp[i-1]相加也不溢出
            //所以取模操作也需要仔细分析
            dp4 = (dp1 + (dp2 + dp3) % 1000000007) % 1000000007;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dp4;
        }

        return dp4;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("The total ways to step is " + solution(n));
    }
}
