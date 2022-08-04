package com.example.learn.algorithm.sword;

import java.util.Stack;

/**
 * @description: 剑指 Offer 31. 栈的压入、弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @author: cheng kai
 * @create: 2021-02-22 14:45
 **/
public class DoesStackPushSeqMatchPopSeq {

    public static boolean solution(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            // num入栈
            stack.push(num);
            // 循环判断与出栈(出栈和入栈相同元素不会进入辅助栈，后者用来暂存不一样的元素)
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped1 = {4, 5, 3, 2, 1};
        int[] popped2 = {4, 3, 5, 1, 2};

        System.out.println("Does pushed match popped1? " + solution(pushed, popped1));
        System.out.println("Does pushed match popped2? " + solution(pushed, popped2));
    }
}
