package com.example.learn.algorithm.classic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 面试题 03.03. 堆盘子
 * <p>
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。
 * SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。
 * 此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。
 * 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt应返回 -1.
 * <p>
 * 链接：https://leetcode-cn.com/problems/stack-of-plates-lcci
 * @author: cheng kai
 * @create: 2021-03-15 19:18
 **/
class StackOfPlates {

    private List<Stack<Integer>> list;

    private int cap;

    public StackOfPlates(int cap) {
        this.list = new ArrayList<>();
        this.cap = cap;
    }

    /**
     * 入栈
     *
     * @param val
     */
    public void push(int val) {
        if (cap <= 0) {
            return;
        }

        if (this.list.isEmpty()) {
            this.list.add(new Stack<>());
        }

        if (this.list.get(this.list.size() - 1).size() >= this.cap) {
            this.list.add(new Stack<>());
        }

        Stack<Integer> stack = this.list.get(this.list.size() - 1);

        stack.push(val);
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (list.size() <= 0) {
            return -1;
        }
        Stack<Integer> stack = this.list.get(this.list.size() - 1);
        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            this.list.remove(this.list.size() - 1);
        }

        return pop;
    }

    /**
     * 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
     *
     * @param index
     * @return
     */
    public int popAt(int index) {
        if (list.size() <= 0 || index > list.size() - 1) {
            return -1;
        }

        Stack<Integer> stack = this.list.get(index);
        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            this.list.remove(index);
        }

        return pop;
    }

    public static void main(String[] args) {
        StackOfPlates stack = new StackOfPlates(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("The size of stackList is " + stack.list.size());

        stack.push(4);
        System.out.println("The size of stackList is " + stack.list.size());

        stack.push(5);
        System.out.println("The size of stackList is " + stack.list.size());

        stack.pop();
        System.out.println("The size of stackList is " + stack.list.size());

        stack.popAt(1);
        System.out.println("The size of stackList is " + stack.list.size());
    }
}