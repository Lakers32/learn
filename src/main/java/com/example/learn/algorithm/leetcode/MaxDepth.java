package com.example.learn.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * @author: 程凯
 * @create: 2022-09-08 23:29
 **/
public class MaxDepth {

    /**
     * 本题可以使用前序（中左右），也可以使用后序遍历（左右中），使用前序求的就是深度，使用后序求的是高度。
     *
     * 二叉树节点的深度：指从根节点到该节点的最长简单路径边的条数或者节点数（取决于深度从0开始还是从1开始）
     * 二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数后者节点数（取决于高度从0开始还是从1开始）
     * 而根节点的高度就是二叉树的最大深度
     */

    /**
     * 递归法：后序遍历(高度)
     */
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = solution(root.left);
        int rightDepth = solution(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 迭代法，使用层序遍历
     */
    public int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }

        return depth;
    }

    /**
     * 前序遍历：较为复杂
     */
    public int solution3(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }

        solution3(root, 1);

        return result;
    }

    int result;

    void solution3(TreeNode node, int depth) {
        // 中
        result = depth > result ? depth : result;

        if (node.left == null && node.right == null) {
            return;
        }

        // 左
        if (node.left != null) {
            depth++;    // 深度+1
            solution3(node.left, depth);
            depth--;    // 回溯，深度-1
        }

        // 右
        if (node.right != null) {
            depth++;    // 深度+1
            solution3(node.right, depth);
            depth--;    // 回溯，深度-1
        }

        return;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(15);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        MaxDepth maxDepth = new MaxDepth();
        System.out.println("Max depth = " + maxDepth.solution(root));
    }
}
