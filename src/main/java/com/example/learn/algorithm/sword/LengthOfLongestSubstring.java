package com.example.learn.algorithm.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 剑指 Offer 48. 最长不含重复字符的子字符串
 * <p>
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * @author: cheng kai
 * @create: 2021-03-01 16:21
 **/
public class LengthOfLongestSubstring {

    /**
     * 动态规划/双指针 + 哈希表
     *
     * @param s
     * @return
     */
    public static int solution(String s) {
        // 上一次字符出现的位置
        Map<Character, Integer> dic = new HashMap<>();
        // dp[j] 与 dp[j-1]
        int longestLength = 0, lastLongestLength = 0;
        for (int j = 0; j < s.length(); j++) {
            // 获取索引 i
            int i = dic.getOrDefault(s.charAt(j), -1);
            // 更新哈希表
            dic.put(s.charAt(j), j);
            // dp[j - 1] -> dp[j]
            lastLongestLength = lastLongestLength < j - i ? lastLongestLength + 1 : j - i;
            // max(dp[j - 1], dp[j])
            longestLength = Math.max(longestLength, lastLongestLength);
        }

        return longestLength;
    }

    /**
     * 动态规划 + 线性遍历
     *
     * @param s
     * @return
     */
    public static int solution2(String s) {
        // dp[j] 与 dp[j-1]
        int longestLength = 0, lastLongestLength = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = j - 1;
            // 线性查找 i
            while (i >= 0 && s.charAt(i) != s.charAt(j)) {
                i--;
            }
            // dp[j - 1] -> dp[j]
            lastLongestLength = lastLongestLength < j - i ? lastLongestLength + 1 : j - i;
            // max(dp[j - 1], dp[j])
            longestLength = Math.max(longestLength, lastLongestLength);
        }

        return longestLength;
    }

    /**
     * 双指针 + 哈希表
     *
     * @param s
     * @return
     */
    public static int solution3(String s) {
        // 上一次字符出现的位置
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, longestLength = 0;
        for (int j = 0; j < s.length(); j++) {
            // 更新左指针 i
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            // 哈希表记录
            dic.put(s.charAt(j), j);
            // 更新结果
            longestLength = Math.max(longestLength, j - i);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("LengthOfLongestSubstring is " + solution3(s));
    }
}
