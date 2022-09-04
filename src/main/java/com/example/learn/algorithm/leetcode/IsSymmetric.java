package com.example.learn.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * https://leetcode.cn/problems/symmetric-tree/
 */
public class IsSymmetric {

    /**
     * 递归法：后序遍历
     * 左子树的遍历方式是左右中，右子树的遍历方式是右左中
     */
    public boolean solution(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }

        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);
        // 比较内侧
        boolean compareInside = compare(left.right, right.left);

        return compareOutside && compareInside;
    }

    /**
     * 迭代法
     * 使用双端队列，相当于两个栈
     */
    public boolean solution2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }

            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }

    /**
     * 迭代法
     * 使用普通队列
     */
    public boolean solution3(TreeNode root) {
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);

        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }

            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }

            // 这里顺序与使用Deque不同
            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }

        return true;
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

        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println("Is Symmetric? " + isSymmetric.solution(root));
    }

}
