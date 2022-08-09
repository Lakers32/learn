package com.example.learn.algorithm.huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
 * <p>
 * 数据范围：保证输入的数字在 32 位浮点数范围内
 */
public class HJ7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double d = scanner.nextDouble();
        int i = (int) d;
        System.out.println((d - i) >= 0.5 ? i + 1 : i);
        // (int)(number + 0.5)
    }
}
