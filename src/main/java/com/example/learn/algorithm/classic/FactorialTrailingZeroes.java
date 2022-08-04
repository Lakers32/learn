package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 16.05. 阶乘尾数
 * <p>
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 * <p>
 * https://leetcode-cn.com/problems/factorial-zeros-lcci/
 * @author: cheng kai
 * @create: 2021-03-20 17:50
 **/
public class FactorialTrailingZeroes {

    /**
     * 解题思路：
     * 1、那么 n 过大时，从 1 遍历到 n, 那么会超时,因此我们修改下规律
     *
     *         n! = 1 * 2 * 3 * 4 * (1 * 5) * ... * (2 * 5) * ... * (3 * 5) ...
     *         我们发现，
     *         每隔 5 个数就会出现 一个 5，因此我们只需要通过 n / 5 来计算存在存在多少个 5 个数，那么就对应的存在多少个 5
     *         但是，我们也会发现
     *         每隔 25 个数会出现 一个 25， 而 25 存在 两个 5，我们上面只计算了 25 的一个 5，因此我们需要 n / 25 来计算存在多少个 25，加上它遗漏的 5
     *         同时，我们还会发现
     *         每隔 125 个数会出现一个 125，而 125 存在 三个 5，我们上面只计算了 125 的两个 5，因此我们需要 n / 125 来计算存在多少个 125，加上它遗漏的 5
     *         ...
     *
     *         因此我们 count = n / 5 + n / 25 + n / 125 + ...
     *         最终分母可能过大溢出，上面的式子可以进行转换
     *
     *         count = n / 5 + n / 5 / 5 + n / 5 / 5 / 5 + ...
     *         因此，我们这样进行循环
     *         n /= 5;
     *         count += n;
     *         这样，第一次加上的就是 每隔 5 个数的 5 的个数，第二次加上的就是 每隔 25 个数的 5 的个数 ...
     * @param n n
     * @return int
     */
    public static int solution(int n) {
        int count = 0;

        while (n >= 5) {
            n /= 5;
            count += n;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println("The factorial trailing zeroes are " + solution(n));
    }

}
