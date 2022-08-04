package com.example.learn.algorithm.sword;

import java.util.Stack;

/**
 * @description: 剑指 Offer 27. 二叉树的镜像
 * <p>
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @author: cheng kai
 * @create: 2021-02-21 16:38
 **/
public class MirrorBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static TreeNode solution(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftTemp = root.left;
        root.left = solution(root.right);
        root.right = solution(leftTemp);

        return root;
    }

    /**
     * 辅助栈（或队列）
     *
     * @param root
     * @return
     */
    public static TreeNode solution2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                stack.push(left);
            }
            if (right != null) {
                stack.push(right);
            }

            node.left = right;
            node.right = left;
        }

        return root;
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

        solution(root);
        System.out.println();
    }
}
