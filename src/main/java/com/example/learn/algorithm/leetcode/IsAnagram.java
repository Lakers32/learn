package com.example.learn.algorithm.leetcode;

/**
 * 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * <p>
 * 链接：https://leetcode.cn/problems/valid-anagram
 */
public class IsAnagram {

    /**
     * 哈希法
     * @param s
     * @param t
     * @return
     */
    public boolean solution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        String s = "anagram", t = "nagaram";
        System.out.println("IsAnagram : " + isAnagram.solution(s, t));

        String s1 = "rat", t1 = "car";
        System.out.println("IsAnagram : " + isAnagram.solution(s1, t1));
    }

}
