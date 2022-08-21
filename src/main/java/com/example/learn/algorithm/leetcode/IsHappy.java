package com.example.learn.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 链接：https://leetcode.cn/problems/happy-number
 */
public class IsHappy {

    /**
     * 难点在于如何 不无限循环，可以使用set集合存储已经访问过的数字
     *
     * @param n
     * @return
     */
    public boolean solution(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    /**
     * 快慢指针
     * 如果 n 是一个快乐数，即没有循环，那么快跑者最终会比慢跑者先到达数字 1（1本身就是快乐数）。
     * 如果 n 不是一个快乐的数字，那么最终快跑者和慢跑者将在同一个数字上相遇。
     *
     * @param n
     * @return
     */
    public boolean solution2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }

        return fastRunner == 1;
    }


    private int getNext(int n) {
        int totalSum = 0;

        // 求各位的平方和
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int num = 19;
        IsHappy isHappy = new IsHappy();
        System.out.println("Is happy ? " + isHappy.solution(num));

    }
}
