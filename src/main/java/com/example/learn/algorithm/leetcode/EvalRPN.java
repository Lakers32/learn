package com.example.learn.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰表达式求值
 *
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 注意两个整数之间的除法只保留整数部分。
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation
 *
 */
public class EvalRPN {

    public int solution(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        String[] tokens = {"2","1","+","3","*"};
        System.out.println("The result is " + evalRPN.solution(tokens));
    }
}
