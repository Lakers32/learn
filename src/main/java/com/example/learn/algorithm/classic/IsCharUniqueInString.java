package com.example.learn.algorithm.classic;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 面试题 01.01. 判定字符是否唯一
 * <p>
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 如果你不使用额外的数据结构，会很加分。
 * <p>
 * https://leetcode-cn.com/problems/is-unique-lcci/
 * @author: cheng kai
 * @create: 2021-03-08 16:01
 **/
public class IsCharUniqueInString {

    /**
     * 辅助数组
     *
     * @param astr
     * @return
     */
    public static boolean solution(String astr) {
        int[] arr = new int[128];
        for (int i = 0; i < astr.length(); i++) {
            //把字符和数组关联
            if (arr[astr.charAt(i)] != 0) {
                return false;
            }
            arr[astr.charAt(i)]++;
        }

        return true;
    }

    /**
     * 若字符串只包含英文字符，则可用位运算
     *
     * @param astr
     * @return
     */
    public static boolean solution2(String astr) {
        long bits = 0;
        int size = astr.length();
        for (int i = 0; i < size; i++) {
            int move = astr.charAt(i) - 'A';
            if ((bits & (1L << move)) != 0) {
                //有重复的，直接返回false
                return false;
            } else {
                //标记当前位置有这个字符
                bits |= (1L << move);
            }
        }

        return true;
    }

    /**
     * 双层循环，两两比较
     *
     * @param astr
     * @return
     */
    public static boolean solution3(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            for (int j = i + 1; j < astr.length(); j++) {
                if (astr.charAt(i) == astr.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 集合set验证重复
     *
     * @param astr
     * @return
     */
    public static boolean solution4(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            //如果有重复的直接返回false
            if (!set.add(astr.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 使用String的indexOf方法
     *
     * @param astr
     * @return
     */
    public static boolean solution5(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            //查看后面是否有当前字符
            if (astr.indexOf(c, i + 1) != -1) {
                return false;
            }
        }

        return true;
    }

    /**
     * 使用String的indexOf和lastIndexOf方法
     *
     * @param astr
     * @return
     */
    public static boolean solution6(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            //判断当前字符从前面和后面索引是否相同，如果不相同，
            //说明有重复的字符，直接返回false
            if (astr.indexOf(c) != astr.lastIndexOf(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String astr = "LeetCode";
        System.out.println("Is char unique in the string? " + solution(astr));
    }
}
