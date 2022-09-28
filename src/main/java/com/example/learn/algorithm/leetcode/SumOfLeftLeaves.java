package com.example.learn.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 左叶子之和
 * <p>
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * <p>
 * https://leetcode.cn/problems/sum-of-left-leaves/
 * @author: 程凯
 * @create: 2022-09-28 22:05
 **/
public class SumOfLeftLeaves {

    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左
        int leftValue = solution(root.left);
        // 右
        int rightValue = solution(root.right);

        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        // 中
        int sum = midValue + leftValue + rightValue;

        return sum;
    }

    public int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return result;
    }

    public int solution3(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                // 左节点不为空
                if (node.left != null) {
                    queue.offer(node.left);
                    // 左叶子节点
                    if (node.left.left == null && node.left.right == null) {
                        sum += node.left.val;
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return sum;
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

        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        System.out.println("sum of left leaves is  " + sumOfLeftLeaves.solution(root));
    }
}
