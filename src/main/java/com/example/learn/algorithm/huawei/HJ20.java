package com.example.learn.algorithm.huawei;

import java.util.Scanner;

/**
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 */
public class HJ20 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            boolean flag = Solution(str);
            if (flag) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    public static boolean Solution(String str) {
        if (str.length() <= 8) {
            return false;
        }
        int num = 0;
        int smallChars = 0;
        int bigChars = 0;
        int other = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                num = 1;
            }
            else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                smallChars = 1;
            }
            else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                bigChars = 1;
            } else {
                other = 1;
            }
        }
        if (num + smallChars + bigChars + other < 3) {
            return false;
        } else {
            for (int i = 0; i < str.length() - 3; i++) {
                String str1 = str.substring(i, i + 3);
                String str2 = str.substring(i + 3);
                if (str2.contains(str1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
