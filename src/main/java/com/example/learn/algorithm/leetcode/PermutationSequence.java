package com.example.learn.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 输出数组的全排列
 * @Author: kotchen
 * @Date: 2021/6/5 18:45
 * @Version: 1.0
 **/
public class PermutationSequence {

    List<List<Integer>> res = new LinkedList<>();

    /**
     * 主函数，输入一组不重复的数字，返回它们的全排列
     *
     * @param nums
     * @return
     */
    List<List<Integer>> solution(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 路径：记录在 track 中
     * 选择列表：nums 中不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     *
     * @param nums
     * @param track
     */
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        // 遍历选择列表
        for (int i = 0; i < nums.length; i++) {
            // 减枝：排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println("Permutation Sequence are " + permutationSequence.solution(nums));
    }
}
