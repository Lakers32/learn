package com.example.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author: kotchen
 * @Date: 2021/5/18 11:14
 * @Version: 1.0
 **/
public class LengthOfLongestSubstring {

    public int solution(String s) {
        int res = 0;
        Map<Character, Integer> chars = new HashMap<>();

        for (int i = 0, j = 0; j < s.length(); ++j) {
            char c = s.charAt(j);
            if (chars.containsKey(c)) {
                i = Math.max(i, chars.get(c) + 1);
            }
            chars.put(c, j);
            // 若需要输入一个最长子串的起始位置，只需要在求最大值交换的时候更新起始位置就行
            res = Math.max(res, j - i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        System.out.println("The Length Of Longest Substring Is " + lengthOfLongestSubstring.solution(s));
    }
}
