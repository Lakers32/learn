package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 19. 正则表达式匹配
 *
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 *
 * @author: cheng kai
 * @create: 2021-02-20 16:07
 **/
public class RegularMatch {
    public static boolean solution(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        System.out.println("Is a match aa ? " + solution("aa", "a"));
        System.out.println("Is a* match aa ? " + solution("aa", "a*"));
        System.out.println("Is .* match ab ? " + solution("ab", ".*"));
        System.out.println("Is c*a*b match aab ? " + solution("aab", "c*a*b"));
        System.out.println("Is mis*is*p*. match mississippi ? " + solution("mississippi", "mis*is*p*."));
    }
}
