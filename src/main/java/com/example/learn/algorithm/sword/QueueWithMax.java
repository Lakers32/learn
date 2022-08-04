package com.example.learn.algorithm.sword;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 剑指 Offer 59 - II. 队列的最大值
 * <p>
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value需要返回 -1
 * <p>
 * 本题类似 {@link edu.nuaa.cs.point.StackWithMin}
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * @author: cheng kai
 * @create: 2021-03-05 14:48
 **/
public class QueueWithMax {

    Queue<Integer> queue;
    Deque<Integer> deque;

    public QueueWithMax() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }

        deque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (queue.peek().equals(deque.peekFirst())) {
            deque.pollFirst();
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        QueueWithMax queue = new QueueWithMax();
        queue.push_back(5);
        queue.push_back(4);
        queue.push_back(6);
        System.out.println("After push 5,4,6, the max value is " + queue.max_value());
        queue.pop_front();
        System.out.println("After pop, the max value is " + queue.max_value());
        queue.push_back(7);
        System.out.println("After push 7, the max value is " + queue.max_value());
        queue.push_back(1);
        System.out.println("After push 1, the max value is " + queue.max_value());
    }

}
