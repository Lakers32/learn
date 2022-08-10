package com.example.learn.algorithm.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 */
public class HJ12 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        String str = sc.nextLine();
        for(int i=0;i<str.length();i++){
            stack.push(str.charAt(i));
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    // 收尾双指针，交换对应位置上的数字即可

    // 直接用reverse()函数
}
