package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 05. 替换空格
 *
 * 请实现一个函数，把字符串s中的每个空格替换成"%20"。
 *
 * @author: cheng kai
 * @create: 2021-02-03 16:41
 **/
public class ReplaceSpace {

    public static String solution(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println("Replace Space " + solution(s));
    }
}
