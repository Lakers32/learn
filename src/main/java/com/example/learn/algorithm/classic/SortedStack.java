package com.example.learn.algorithm.classic;

import java.util.Stack;

/**
 * @description: 面试题 03.05. 栈排序
 * <p>
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * <p>
 * https://leetcode-cn.com/problems/sort-of-stacks-lcci/
 * @author: cheng kai
 * @create: 2021-03-15 19:42
 **/
class SortedStack {

    /**
     * stack是排序栈，helpStack是排序辅助栈
     */
    private Stack<Integer> stack, helpStack;

    public SortedStack() {
        stack = new Stack<>();
        helpStack = new Stack<>();
    }

    public void push(int val) {
        //找到合适位置插入val
        while (!stack.isEmpty() && stack.peek() < val) {
            helpStack.push(stack.pop());
        }
        stack.push(val);

        //将暂存在helpStack中的元素重新复原到stack
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
        stack.push(9);
        stack.push(10);
        stack.push(7);
        stack.push(3);
        stack.push(5);

        System.out.println("Tap number is " + stack.peek());
        stack.pop();

        System.out.println("After pop, tap number is " + stack.peek());
    }
}