package com.example.learn.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用队列实现栈
 * <p>
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * https://leetcode.cn/problems/implement-stack-using-queues/
 */
public class MyStack {

    // Deque 接口继承了 Queue 接口
    // 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
    Deque<Integer> que;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        que = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        que.addLast(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int size = que.size();
        size--;
        while (size-- > 0) {
            que.addLast(que.peekFirst());
            que.pollFirst();
        }

        int res = que.pollFirst();
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return que.peekLast();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return que.isEmpty();
    }
}
