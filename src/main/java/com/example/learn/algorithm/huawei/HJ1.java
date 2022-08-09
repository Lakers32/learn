package com.example.learn.algorithm.huawei;

import java.util.Scanner;

/**
 * 字符串最后一个单词的长度
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 *
 * https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 *
 */
public class HJ1 {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String s = "";
        while (input.hasNextLine()) {
            s = input.nextLine();
            System.out.println(s.length() - 1 - s.lastIndexOf(" "));
        }
    }

}
