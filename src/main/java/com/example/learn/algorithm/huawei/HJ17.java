package com.example.learn.algorithm.huawei;

import java.util.Scanner;

/**
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 */
public class HJ17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] arr = str.split(";");
            int x = 0;
            int y = 0;
            for (int i = 0; i < arr.length; i++) {
                //判断是否是合法字符
                try {
                    int b = Integer.parseInt(arr[i].substring(1));
                    char dir = arr[i].charAt(0);
                    if (dir == 'A') {
                        x -= b;
                    }
                    if (dir == 'W') {
                        y += b;
                    }
                    if (dir == 'S') {
                        y -= b;
                    }
                    if (dir == 'D') {
                        x += b;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            System.out.println(x + "," + y);
        }
    }
}
