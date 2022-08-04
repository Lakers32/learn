package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 03.01. 三合一
 * <p>
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>
 * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
 * @author: cheng kai
 * @create: 2021-03-15 16:12
 **/
public class SimulateThreeStacksUsingArray {

    /**
     * 定义一个数组栈
     */
    private int[] stack;

    /**
     * 定义一个头指针的数组
     */
    private int[] top;

    /**
     * 数值3
     */
    private int three = 3;

    public SimulateThreeStacksUsingArray(int stackSize) {
        // 定义三栈合一
        stack = new int[stackSize * three];
        // 三个栈的头结点
        top = new int[three];

        // 分别赋值第一次的头结点
        // 栈0 top[0] = 0;
        // 栈1 top[1] = 1;
        // 栈2 top[2] = 2;
        for (int i = 0; i < three; i++) {
            top[i] = i;
        }
    }

    public void push(int stackNum, int value) {
        // 判断是否添加满了
        if (top[stackNum] < stack.length) {
            // 赋值
            stack[top[stackNum]] = value;
            // 头结点+three
            top[stackNum] = top[stackNum] + three;
        }
    }

    public int pop(int stackNum) {
        // 判断是否为空
        if (isEmpty(stackNum)) {
            return -1;
        }

        // 原本的top[stackNum]-three
        top[stackNum] = top[stackNum] - three;

        // 返回
        return stack[(top[stackNum])];
    }

    public int peek(int stackNum) {
        // 判断是否为空
        if (isEmpty(stackNum)) {
            return -1;
        }

        // 把下标给它但是不改变原来的top[stackNum]
        int index = top[stackNum] - three;

        return stack[index];
    }

    public boolean isEmpty(int stackNum) {
        // 判断这个栈是否为空
        if (top[stackNum] - three < 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        SimulateThreeStacksUsingArray simulate = new SimulateThreeStacksUsingArray(2);

        simulate.push(0, 0);
        simulate.push(1, 1);
        simulate.push(2, 2);

        System.out.println("The second stack top value is " + simulate.peek(1));

        simulate.push(1, 11);
        System.out.println("The second stack top value is " + simulate.peek(1));
        simulate.push(1, 111);
        System.out.println("The second stack top value is " + simulate.peek(1));

        System.out.println("Is second stack empty? " + simulate.isEmpty(1));

        simulate.pop(1);
        System.out.println("The second stack top value is " + simulate.peek(1));
        System.out.println("Is second stack empty? " + simulate.isEmpty(1));
        simulate.pop(1);
        System.out.println("The second stack top value is " + simulate.peek(1));
        System.out.println("Is second stack empty? " + simulate.isEmpty(1));

    }
}