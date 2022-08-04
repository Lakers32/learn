package com.example.learn.algorithm.sword;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: 剑指 Offer 41. 数据流中的中位数
 * <p>
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * @author: cheng kai
 * @create: 2021-02-25 16:21
 **/
public class FindMedian {

    Queue<Integer> minHeap, maxHeap;

    public FindMedian() {
        /**
         * 小顶堆，保存较大的一半，堆顶是大元素中的最小值
         */
        minHeap = new PriorityQueue<>();
        /**
         * 大顶堆，保存较小的一半，堆顶是小元素中最大值
         */
        maxHeap = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (minHeap.size() != maxHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        return minHeap.size() != maxHeap.size() ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        FindMedian findMedian = new FindMedian();

        findMedian.addNum(3);
        System.out.println("The new median is " + findMedian.findMedian());
        findMedian.addNum(1);
        System.out.println("The new median is " + findMedian.findMedian());
        findMedian.addNum(4);
        System.out.println("The new median is " + findMedian.findMedian());
        findMedian.addNum(6);
        System.out.println("The new median is " + findMedian.findMedian());
        findMedian.addNum(5);
        System.out.println("The new median is " + findMedian.findMedian());
        findMedian.addNum(1);
        System.out.println("The new median is " + findMedian.findMedian());
    }
}
