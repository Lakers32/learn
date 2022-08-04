package com.example.learn.algorithm.sword;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: 剑指 Offer 50. 第一个只出现一次的字符
 * <p>
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @author: cheng kai
 * @create: 2021-03-02 14:05
 **/
public class FirstUniqChar {

    /**
     * 哈希表
     *
     * @param str
     * @return
     */
    public static char solution(String str) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            dic.put(c, !dic.containsKey(c));
        }
        for (char c : chars) {
            if (dic.get(c)) {
                return c;
            }
        }

        return ' ';
    }

    /**
     * 有序哈希表
     *
     * @param str
     * @return
     */
    public static char solution2(String str) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            dic.put(c, !dic.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            if (d.getValue()) {
                return d.getKey();
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        String str = "abaccdeff";

        System.out.println("The first unique char is " + solution(str));
    }
}
