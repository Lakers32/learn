package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 01.02. 判定是否互为字符重排
 * <p>
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * https://leetcode cn.com/problems/check permutation lcci/
 * @author: cheng kai
 * @create: 2021 03 08 16:42
 **/
public class CheckCharPermutationInString {

    /**
     * 根据ASCII码运用桶计法
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean solution(String s1, String s2) {
        int length1 = s1.length(), length2 = s2.length();
        // 长度都不同，肯定不会是
        if (length1 != length2) {
            return false;
        }

        // 长度相同时，根据ASCII码运用桶计法
        // s1作为原串，s2作为重排串
        int[] array = new int[128];
        for (int i = 0; i < length1; i++) {
            // 统计原串中每种字符的数量
            array[s1.charAt(i)]++;
            // 重排串用掉了字符
            array[s2.charAt(i)]--;
        }

        // 如果互为字符重排，那么array数组中所有元素应该都为0
        for (int x : array) {
            if (x != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        System.out.println("Check char permutation in string? " + solution(s1, s2));
    }
}
