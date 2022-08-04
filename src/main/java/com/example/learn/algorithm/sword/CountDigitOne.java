package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * <p>
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * @author: cheng kai
 * @create: 2021-03-01 10:00
 **/
public class CountDigitOne {

    /**
     * 遍历1到n，逐个获取到分位置上的数值，判断其是不是1，然后把满足条件的数值个数累加起来
     *
     * @param n
     * @return
     */
    public static int solution1(int n) {
        return 0;
    }

    /**
     * 按位计算
     *
     * @param n
     * @return
     */
    public static int solution2(int n) {
        int digit = 1, count = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) {
                count += high * digit;
            } else if(cur == 1) {
                count += high * digit + low + 1;
            } else {
                count += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println("Digit ones count is " + solution2(n));
    }
}
