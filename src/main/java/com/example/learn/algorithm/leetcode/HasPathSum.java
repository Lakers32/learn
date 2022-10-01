package com.example.learn.algorithm.leetcode;

import java.util.Stack;

/**
 * @description: 路径总和
 * <p>
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * 链接：https://leetcode.cn/problems/path-sum
 * @author: 程凯
 * @create: 2022-10-01 09:50
 **/
public class HasPathSum {

    /**
     * 递归法
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean solution(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        targetSum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        if (root.left != null) {
            boolean left = solution(root.left, targetSum);
            // 已经找到
            if (left) {
                return true;
            }
        }
        if (root.right != null) {
            boolean right = solution(root.right, targetSum);
            // 已经找到
            if (right) {
                return true;
            }
        }

        // 左右都没有找到
        return false;
    }

    /**
     * 递归法：精简版
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean solution2(TreeNode root, int targetSum) {
        // 为空退出
        if (root == null) {
            return false;
        }

        // 叶子节点判断是否符合
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // 求两侧分支的路径和
        return solution2(root.left, targetSum - root.val) || solution2(root.right, targetSum - root.val);
    }

    /**
     * @param root
     * @param targetSum
     * @return
     */
    public boolean solution3(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // stack1和stack2共进退，保证顺利一致
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root.val);
        while (!stack1.isEmpty()) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack1.pop();
                int sum = stack2.pop();
                // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
                if (node.left == null && node.right == null && sum == targetSum) {
                    return true;
                }
                // 右节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if (node.right != null) {
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }
                // 左节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if (node.left != null) {
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        HasPathSum hasPathSum = new HasPathSum();
        int targetSum = 38;
        System.out.println("Has Path Sum? " + hasPathSum.solution(root, targetSum));
    }
}
