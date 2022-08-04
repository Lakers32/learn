package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 05.03. 翻转数位
 * <p>
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * https://leetcode-cn.com/problems/reverse-bits-lcci/
 * @author: cheng kai
 * @create: 2021-03-19 19:31
 **/
public class ReverseBits {
    public static int solution(int num) {
        int cnt = 1;
        int pos = -1;
        int result = 0;

        for (int i = 0; i <= 32; i++) {
            if ((num & 1) == 1) {
                cnt++;
            } else {
                result = Math.max(result, cnt);
                cnt = i - pos;
                pos = i;
            }
            num >>>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int num = 1775;

        System.out.println("The new num is " + solution(num));
    }
}
