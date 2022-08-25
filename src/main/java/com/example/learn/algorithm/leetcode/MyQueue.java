package com.example.learn.algorithm.leetcode;

import java.util.Stack;

/**
 * 用栈实现队列
 * <p>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）
 * <p>
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 */
public class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        // 负责进栈
        stackIn = new Stack<>();
        // 负责出栈
        stackOut = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
    private void dumpstackIn() {
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
