package com.example.learn.algorithm.classic;

/**
 * @description:面试题 01.09. 字符串轮转
 * <p>
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成。
 * 比如，waterbottle是erbottlewat旋转后的字符串。
 * <p>
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 * @author: cheng kai
 * @create: 2021-03-09 20:51
 **/
public class IsFlippedString {

    public static boolean solution(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        return s1.equals(s2) || (s1.length() == s2.length() && (s1 + s1).contains(s2));
    }

    public static void main(String[] args) {
        String str1 = "waterbottle";
        String str2 = "erbottlewat";

        System.out.println("Is flipped string? " + solution(str1, str2));
    }
}
