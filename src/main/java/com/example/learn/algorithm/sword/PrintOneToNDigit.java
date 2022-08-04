package com.example.learn.algorithm.sword;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 17. 打印从1到最大的n位数
 * <p>
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出 1、2、3一直到最大的3位数999。
 * <p>
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @author: cheng kai
 * @create: 2021-02-20 09:47
 **/
public class PrintOneToNDigit {

    public static int[] solution(int n) {
        if (n < 0) {
            return null;
        }
        if (n == 0) {
            return new int[1];
        }
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= 10;
        }

        return printNumbers(product);
    }

    private static int[] printNumbers(int max) {
        int[] numbers = new int[max - 1];
        for (int i = 1; i < max; i++) {
            numbers[i-1] = i;
        }
        return numbers;
    }

    public static void main(String[] args) {
        System.out.println("0位数的所有数字为" + Arrays.toString(solution(0)));
        System.out.println("1位数的所有数字为" + Arrays.toString(solution(1)));
        System.out.println("2位数的所有数字为" + Arrays.toString(solution(2)));
    }
}
