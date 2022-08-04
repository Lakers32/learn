package com.example.learn.algorithm.sword;

/**
 * @description: 数字序列中某一位的数字
 * <p>
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * @author: cheng kai
 * @create: 2021-03-01 11:08
 **/
public class NthDigitInNumSeq {

    public static int solution(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        int index = 5;
        System.out.println("The index number is " + solution(index));
    }
}
