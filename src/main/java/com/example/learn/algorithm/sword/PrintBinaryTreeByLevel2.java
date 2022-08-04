package com.example.learn.algorithm.sword;

import java.util.*;

/**
 * @description: 剑指 Offer 32-II. 从上到下打印二叉树 II（按层打印二叉树）
 * <p>
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * @author: cheng kai
 * @create: 2021-02-22 15:42
 **/
public class PrintBinaryTreeByLevel2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> solution(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> levelVales = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> vales = new LinkedList<>();
            // 一次while循环中，队列中均为本层的数值
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                vales.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            levelVales.add(vales);
        }

        return levelVales;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
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

        System.out.println("Print binary tree by level: " + (solution(root)));
    }
}
