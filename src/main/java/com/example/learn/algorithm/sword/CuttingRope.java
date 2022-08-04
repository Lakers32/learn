package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 14- I. 剪绳子
 * <p>
 * 给你一根长度为n的绳子，请把绳子剪成整数长度的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1]，请问 k[0]*k[1]*...*k[m-1]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * @author: cheng kai
 * @create: 2021-02-13 21:24
 **/
public class CuttingRope {

    /**
     * 切分规则：
     * 最优：3。把绳子尽可能切为多个长度为3的片段，留下的最后一段绳子的长度可能为0,1,2三种情况。
     * 次优：2。若最后一段绳子长度为2；则保留，不再拆为1+1 。
     * 最差：1。若最后一段绳子长度为1；则应把一份3+1替换为2+2，因为2x2 > 3×3。
     *
     * @param n
     * @return
     */
    public static int solution(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;

        if (b == 0) {
            return (int) Math.pow(3, a);
        }

        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }

        // b == 2
        return (int) Math.pow(3, a) * 2;
    }

    public static void main(String[] args) {
        System.out.println("8 max multiple is " + solution(8));

        System.out.println("3 max multiple is " + solution(3));

        System.out.println("2 max multiple is " + solution(2));

        System.out.println("1 max multiple is " + solution(1));
    }
}
