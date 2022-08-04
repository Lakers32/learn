package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 01.05. 一次编辑
 * <p>
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * https://leetcode-cn.com/problems/one-away-lcci/
 * @author: cheng kai
 * @create: 2021-03-08 19:31
 **/
public class CheckStringOneEditAway {


    /**
     * 字符串比较
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean solution(String first, String second) {
        if (first == null || second == null) {
            return true;
        }

        int length1 = first.length(), length2 = second.length();
        if (length1 == 0 && length2 <= 1) {
            return true;
        }
        if (length2 == 0 && length1 <= 1) {
            return true;
        }

        // 1、零次编辑：直接比较字符串相同索引位置的字符是否一样--->与情形4替换合并

        // 2、插入：逐个比较字符，遇到不一致的，将编辑后的字符索引+1(编辑后比编辑前多一个字符)，后继续逐个比较
        int notMatchCount = 0;
        if (length1 + 1 == length2) {
            for (int i = 0, j = 0; i < length1 && j < length2; ) {
                if (first.charAt(i) != second.charAt(j)) {
                    if (notMatchCount >= 1) {
                        return false;
                    }
                    notMatchCount++;
                } else {
                    i++;
                }
                j++;
            }
            return true;
        }

        // 3、删除：逐个比较字符，遇到不一致的，将编辑前的字符索引+1(编辑前比编辑后多一个字符)，后继续逐个比较--->若二者交换，则可复制插入代码
        notMatchCount = 0;
        if (length1 == length2 + 1) {
            for (int i = 0, j = 0; i < length1 && j < length2; ) {
                if (first.charAt(i) != second.charAt(j)) {
                    if (notMatchCount >= 1) {
                        return false;
                    }
                    notMatchCount++;
                } else {
                    j++;
                }
                i++;
            }
            return true;
        }

        // 4、替换：逐个比较字符，遇到不一致的，将双方的字符索引+1(编辑前与编辑后的字符数相等)，后继续逐个比较
        notMatchCount = 0;
        if (length1 == length2) {
            for (int i = 0; i < length1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    // 0次是无编辑，1次是编辑一个字符
                    if (notMatchCount >= 1) {
                        return false;
                    }
                    notMatchCount++;
                }
            }
            return true;
        }

        return false;
    }

    /**
     * 二维动态规划
     * 双循环，效率低
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean solution2(String first, String second) {
        int len1 = first.length(), len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //考虑增删改
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1), dp[i][j - 1] + 1);
                }
            }
        }

        return dp[len1][len2] <= 1;
    }

    public static void main(String[] args) {
        String first = "teacher";
        String second = "bleacher";

        System.out.println("Check string one edit away? " + solution(first, second));
    }

}
