package com.example.learn.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @Author: kotchen
 * @Date: 2021/6/7 10:46
 * @Version: 1.0
 **/
public class MinDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 深度优先搜索(后序遍历)
     *
     * @param root
     * @return
     */
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(solution(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(solution(root.right), min_depth);
        }

        return min_depth + 1;
    }

    /**
     * 广度优先搜索(按层遍历)
     *
     * @param root
     * @return
     */
    public int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        MinDepthOfBinaryTree binaryTree = new MinDepthOfBinaryTree();
        System.out.println("The min depth is " + binaryTree.solution2(root));
    }

}
