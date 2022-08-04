package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 58 - I. 翻转单词顺序
 * <p>
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * @author: cheng kai
 * @create: 2021-03-05 10:18
 **/
public class ReverseWordsInAString {

    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public static String solution(String s) {
        // 删除首尾空格
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder reversedString = new StringBuilder();
        while (i >= 0) {
            // 搜索首个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
            reversedString.append(s.substring(i + 1, j + 1) + " ");
            // 跳过单词间空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return reversedString.toString().trim();
    }

    /**
     * 分割 + 倒序
     *
     * @param s
     * @return
     */
    public static String solution2(String s) {
        // 删除首尾空格，分割字符串
        String[] splitStrings = s.trim().split(" ");
        StringBuilder reversedString = new StringBuilder();
        // 倒序遍历单词列表
        for (int i = splitStrings.length - 1; i >= 0; i--) {
            // 遇到空单词则跳过
            if (splitStrings[i].equals("")) {
                continue;
            }
            // 将单词拼接至 StringBuilder
            reversedString.append(splitStrings[i] + " ");
        }

        // 转化为字符串，删除尾部空格，并返回
        return reversedString.toString().trim();
    }

    public static void main(String[] args) {
        String s = "  hello world!  ";

        System.out.println("(1) The reversed string is: " + solution(s));
        System.out.println("(2) The reversed string is: " + solution2(s));
    }
}
