package com.example.learn.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * <p>
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class HJ4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        while (s.length() >= 8) {
            System.out.println(s.substring(0, 8));
            s = s.substring(8);
        }
        if (s.length() < 8 && s.length() > 0) {
            s = s + "00000000";
            System.out.println(s.substring(0, 8));
        }
    }

}
