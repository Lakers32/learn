package com.example.learn.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * @author: 程凯
 * @create: 2022-09-09 22:41
 **/
public class MinDepth {

    /**
     * 递归法，相比求MaxDepth要复杂点
     * 因为最小深度是从根节点到最近**叶子节点**的最短路径上的节点数量
     */
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = solution(root.left);
        int rightDepth = solution(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }

        // 左右结点都不为null
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 迭代法，层序遍历
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
                TreeNode poll = deque.poll();
                // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return depth;
    }

    /**
     * 前序遍历
     */
    int result;
    public int solution3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = Integer.MIN_VALUE;
        solution3(root, 1);
        return result;
    }

    void solution3(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            result = Math.min(depth, result);
            return;
        }

        // 中 只不过中没有处理的逻辑
        if (node.left == null) {
            solution3(node.left, depth + 1);
        }
        if (node.right == null) {
            solution3(node.right, depth + 1);
        }
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

        MinDepth minDepth = new MinDepth();
        System.out.println("Min depth = " + minDepth.solution(root));
    }

}
