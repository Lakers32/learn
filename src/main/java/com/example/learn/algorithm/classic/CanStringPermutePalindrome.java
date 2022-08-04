package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 01.04. 回文排列
 * <p>
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 * <p>
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * @author: cheng kai
 * @create: 2021-03-08 17:57
 **/
public class CanStringPermutePalindrome {

    /**
     * 位辅助数组
     * 其实也跟回文没啥关系，就是简单判断一下字符串中的字符最多只有一个出现了1次，其他都是偶数次
     *
     * @param s
     * @return
     */
    public static boolean solution(String s) {
        char[] alphabets = new char[128];
        char[] chars = s.toCharArray();
        int cnt = 0;

        // 记录每一个字符，在s中的出现次数
        for (char aChar : chars) {
            alphabets[aChar]++;
        }

        for (char alphabet : alphabets) {
            if (alphabet % 2 == 1) {
                // 最多只有一个数字出现一次
                if (cnt >= 1) {
                    return false;
                }
                cnt++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "tactcoa";
        System.out.println("Can the string permute palindrome? " + solution(s));
    }
}
