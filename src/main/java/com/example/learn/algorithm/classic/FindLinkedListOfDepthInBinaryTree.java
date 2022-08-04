package com.example.learn.algorithm.classic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 面试题 04.03. 特定深度节点链表
 * <p>
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * <p>
 * https://leetcode-cn.com/problems/list-of-depth-lcci/
 * @author: cheng kai
 * @create: 2021-03-17 09:24
 **/
public class FindLinkedListOfDepthInBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 层序遍历
     * 参考{@link edu.nuaa.cs.point.PrintBinaryTreeByLevel2}
     *
     * @param tree
     * @return
     */
    public static ListNode[] solution(TreeNode tree) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        List<ListNode> res = new ArrayList<>();
        ListNode dummy = new ListNode(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode curr = dummy;

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                curr.next = new ListNode(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                curr = curr.next;
            }

            res.add(dummy.next);
            dummy.next = null;
        }

        return res.toArray(new ListNode[]{});
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

