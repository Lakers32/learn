package com.example.learn.algorithm.huawei;

import java.util.Scanner;

/**
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */
public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans = "";
        while (n / 10 != 0) {
            ans = ans + n % 10;
            n = n / 10;
        }
        ans = ans + n;
        System.out.print(ans);
    }
}
