package com.example.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 前 K 个高频元素
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class TopKFrequent {

    public int[] solution(int[] nums, int k) {
        // 遍历计数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 维护大顶堆
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值，构建于一个大顶堆（o1 - o2: 小顶堆， o2 - o1 : 大顶堆）
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
        }

        // 返回结果
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        TopKFrequent topKFrequent = new TopKFrequent();
        System.out.println("topKFrequent are " + topKFrequent.solution(nums, k));
    }
}
