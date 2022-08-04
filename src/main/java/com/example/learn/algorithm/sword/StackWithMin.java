package com.example.learn.algorithm.sword;

import java.util.Stack;

/**
 * @description: 剑指 Offer 30. 包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 * <p>
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @author: cheng kai
 * @create: 2021-02-22 14:07
 **/
public class StackWithMin {

    /**
     * A是正常栈，负责push及pop；B是辅助栈，负责调用min
     */
    Stack<Integer> A, B;

    public StackWithMin() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x) {
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(9);
        stack.push(10);
        stack.push(7);
        stack.push(3);
        stack.push(5);

        System.out.println("Min number is " + stack.min());
        System.out.println("Tap number is " + stack.top());
        stack.pop();
        System.out.println("After pop, min number is " + stack.min());
        System.out.println("After pop, tap number is " + stack.top());
    }
}
