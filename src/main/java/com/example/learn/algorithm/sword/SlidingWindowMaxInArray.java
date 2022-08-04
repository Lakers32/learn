package com.example.learn.algorithm.sword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 剑指 Offer 59 - I. 滑动窗口的最大值
 * <p>
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * @author: cheng kai
 * @create: 2021-03-05 11:35
 **/
public class SlidingWindowMaxInArray {

    /**
     * 回忆《剑指 Offer 30. 包含 min 函数的栈》 {@link edu.nuaa.cs.point.StackWithMin}，其使用 单调栈 实现了随意入栈、出栈情况下的 O(1) 时间获取 “栈内最小值” 。
     * 本题同理，不同点在于 “出栈操作” 删除的是 “列表尾部元素” ，而 “窗口滑动” 删除的是 “列表首部元素” (列表首到尾是递减)。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] solution(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] slidingWindowMaxs = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();
            }

            // 保持 deque 递减
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);

            // 记录窗口最大值
            if (i >= 0) {
                slidingWindowMaxs[i] = deque.peekFirst();
            }
        }

        return slidingWindowMaxs;
    }

    /**
     * 可以将 “未形成窗口” 和 “形成窗口后” 两个阶段拆分到两个循环里实现。代码虽变长，但减少了冗余的判断操作。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] solution2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] slidingWindowMaxs = new int[nums.length - k + 1];
        // 未形成窗口时，初始化双向队列，保证deque里面的元素到当前元素位置为止是从队首到队尾递减(也就是说，某些元素可能比队尾元素大，但是被删除了，例如测试例子中的第一个元素1)
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }

        slidingWindowMaxs[0] = deque.peekFirst();
        // 形成窗口后
        for (int i = k; i < nums.length; i++) {
            // 删除非本次窗口的最大值
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            // 继续填充双向队列，保证deque里面的元素到当前元素位置为止是从队首到队尾递减
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            // 将当前窗口最大值复制给目标返回值
            slidingWindowMaxs[i - k + 1] = deque.peekFirst();
        }

        return slidingWindowMaxs;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // System.out.println("Sliding window maxs are " + solution(nums, k));
        System.out.println("Sliding window maxs are " + solution2(nums, k));
    }

}
