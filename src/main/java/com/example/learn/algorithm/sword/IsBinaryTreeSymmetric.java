package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 28. 对称的二叉树
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @author: cheng kai
 * @create: 2021-02-21 17:32
 **/
public class IsBinaryTreeSymmetric {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 1、先镜像二叉树 {@link edu.nuaa.cs.point.MirrorBinaryTree}
     * 2、再判断1中得到的二叉树是否与原二叉树一样
     *
     * @param root
     * @return
     */
    public static boolean solution(TreeNode root) {

        return true;
    }

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public static boolean solution2(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    private static boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return recur(left.left, right.right) && recur(right.left, left.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println("Is binary tree symmetric? " + solution2(root));
    }
}
