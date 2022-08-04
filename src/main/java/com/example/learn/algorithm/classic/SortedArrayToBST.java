package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 04.02. 最小高度树
 * <p>
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 * @author: cheng kai
 * @create: 2021-03-16 19:38
 **/
public class SortedArrayToBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode solution(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int low, int high) {
        // low > high表示子数组为空
        if (low > high) {
            return null;
        }
        // 以mid作为根节点
        int mid = (high - low) / 2 + low;
        TreeNode root = new TreeNode(nums[mid]);

        // 左子数组[low, mid -1]构建左子树
        root.left = helper(nums, low, mid - 1);
        // 右子数组[mid + 1, high]构建右子树
        root.right = helper(nums, mid + 1, high);

        return root;
    }

    public static void main(String[] args) {
        /**
         * 已经排序
         */
        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = solution(nums);
        System.out.println("");
    }
}