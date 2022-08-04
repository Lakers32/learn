package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 58 - II. 左旋转字符串
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * @author: cheng kai
 * @create: 2021-03-05 11:01
 **/
public class ReverseLeftWordsInAString {

    /**
     * 字符串切片
     *
     * @param s
     * @param n
     * @return
     */
    public static String solution(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * 列表遍历拼接
     *
     * @param s
     * @param n
     * @return
     */
    public static String solution2(String s, int n) {
        StringBuilder reversedLeftString = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            reversedLeftString.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            reversedLeftString.append(s.charAt(i));
        }

        return reversedLeftString.toString();
    }

    /**
     * 列表遍历拼接 + 求余运算
     *
     * @param s
     * @param n
     * @return
     */
    public static String solution3(String s, int n) {
        StringBuilder reversedLeftString = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            reversedLeftString.append(s.charAt(i % s.length()));
        }

        return reversedLeftString.toString();
    }

    /**
     * 字符串遍历拼接
     *
     * @param s
     * @param n
     * @return
     */
    public static String solution4(String s, int n) {
        String reversedLeftString = "";
        for (int i = n; i < s.length(); i++) {
            reversedLeftString += s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            reversedLeftString += s.charAt(i);
        }

        return reversedLeftString;
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;

        System.out.println("(1) The reversed left string is: " + solution(s, k));
        System.out.println("(2) The reversed left string is: " + solution2(s, k));
        System.out.println("(3) The reversed left string is: " + solution3(s, k));
        System.out.println("(4) The reversed left string is: " + solution4(s, k));
    }

}
