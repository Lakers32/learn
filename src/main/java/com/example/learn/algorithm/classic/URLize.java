package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 01.03. URL化
 * <p>
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 * @author: cheng kai
 * @create: 2021-03-08 17:40
 **/
public class URLize {

    /**
     * 字符数组辅助法
     *
     * @param S
     * @param length
     * @return
     */
    public static String solution(String S, int length) {
        if (S == null || S.length() == 0 || length == 0) {
            return null;
        }

        char[] ch = new char[length * 3];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                ch[index++] = '%';
                ch[index++] = '2';
                ch[index++] = '0';
            } else {
                ch[index] = c;
                index++;
            }
        }

        return new String(ch, 0, index);
    }

    public static void main(String[] args) {
        String S = "Mr John Smith    ";
        int length = 13;

        System.out.println("URLize [" + S + "] returns [" + solution(S, length) + "]");
    }

}
