package com.example.learn.algorithm.huawei;

import java.util.Scanner;

/**
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 *
 */
public class HJ9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int len = s.length();
            int[] arr1 = new int[10];
            //这里的意思是一共有10个数字
            for (int i = len - 1; i >= 0; i--) {
                //i=len-1,表示从右往左进行遍历，
                if (arr1[s.charAt(i) - 48] == 0) {
                    System.out.print(s.charAt(i) - 48);
                    arr1[s.charAt(i) - 48]++;
                }
            }
        }
    }
}
