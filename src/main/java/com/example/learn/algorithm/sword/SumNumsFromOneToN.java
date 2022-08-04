package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 64. 求1+2+…+n
 * <p>
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @author: cheng kai
 * @create: 2021-03-06 14:38
 **/
public class SumNumsFromOneToN {

    /**
     * 递归 + 短路运算符
     *
     * @param n
     * @return
     */
    public static int solution(int n) {
        // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递
        boolean x = n > 1 && (n += solution(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println("Sum 1 to " + n + " equals " + solution(n));
    }
}
