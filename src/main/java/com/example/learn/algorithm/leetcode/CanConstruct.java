package com.example.learn.algorithm.leetcode;

/**
 * 赎金信
 * <p>
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * <p>
 * https://leetcode.cn/problems/ransom-note/
 */
public class CanConstruct {

    public boolean solution(String ransomNote, String magazine) {
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for (int i : record) {
            if (i < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CanConstruct canConstruct = new CanConstruct();

        String ransomNote = "aa", magazine = "aa";
        System.out.println("CanConstruct ? " + canConstruct.solution(ransomNote, magazine));
    }
}
