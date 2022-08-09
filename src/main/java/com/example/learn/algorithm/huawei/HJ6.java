package com.example.learn.algorithm.huawei;

import java.util.Scanner;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 */
public class HJ6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();
        long k = (long) Math.sqrt(num);

        for (long i = 2; i <= k; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }

        System.out.println(num == 1 ? "" : num + " ");
    }
}
