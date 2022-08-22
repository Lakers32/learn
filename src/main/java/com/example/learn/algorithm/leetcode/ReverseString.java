package com.example.learn.algorithm.leetcode;

/**
 * 反转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 链接：https://leetcode.cn/problems/reverse-string
 */
public class ReverseString {
    public void solution(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            swap(s, l, r);
            l++;
            r--;
        }
    }

    private void swap(char[] s, int l, int r) {
        //构造 a ^ b 的结果，并放在 a 中
        s[l] ^= s[r];
        //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
        s[r] ^= s[l];
        //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
        s[l] ^= s[r];
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Before " + s);

        ReverseString reverseString = new ReverseString();
        reverseString.solution(s);
        System.out.println("After " + s);
    }
}
