package com.example.learn.algorithm.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * 句子逆序
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 */
public class HJ13 {

    public static void main(String[] args) {

        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            for (int i = 0; i < s.length; i++) {
                stack.push(s[i]);
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
    }

    // 先split，再从后先前加入到新字符串中

    // 先全部反转，再split，接着将各个单词再次反转
    // 先全部反转，再split，接着将各个单词再次反转
}
