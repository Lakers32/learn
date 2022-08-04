package com.example.learn.algorithm.classic;

import edu.nuaa.cs.point.TransferBinarySearchTreeToDoubleLinkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 面试题 17.12. BiNode
 * <p>
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * 返回转换后的单向链表的头节点。
 * <p>
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 * @author: cheng kai
 * @create: 2021-03-22 15:45
 **/
public class TransferBinarySearchTreeToLinkedList {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public TreeNode solution(TreeNode root) {
        // 单链表的头指针哨兵
        TreeNode head = new TreeNode(0);
        // 移动的链表前置指针
        TreeNode prev = head;
        // 开始中序遍历
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();

                // ---链表处理开始
                // 当前节点左指针置空
                node.left = null;
                // 前置指针右指针指向当前节点，作为链表的next指针，链表新增元素
                prev.right = node;
                // 指针后移
                prev = node;
                // ---链表处理结束

                // 中序遍历进入右子树
                node = node.right;
            }
        }

        return head.right;
    }

    /**
     * 递归(中序遍历)
     * 转换成双向链表请参考 {@link TransferBinarySearchTreeToDoubleLinkedList}
     *
     * @param root
     * @return
     */
    public TreeNode solution2(TreeNode root) {
        // 单链表的伪头指针(若不使用，可以参考 {@link TransferBinarySearchTreeToDoubleLinkedList})
        TreeNode head = new TreeNode(0);

        // 开始中序遍历
        inorder(root, head);

        return head.right;
    }

    private TreeNode inorder(TreeNode cur, TreeNode prev) {
        if (cur != null) {
            prev = inorder(cur.left, prev);

            // ---链表处理开始
            cur.left = null;
            prev.right = cur;
            prev = cur;
            // ---链表处理结束

            prev = inorder(cur.right, prev);
        }

        return prev;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        TransferBinarySearchTreeToLinkedList transfer = new TransferBinarySearchTreeToLinkedList();

/*        TreeNode head = transfer.solution(root);
        System.out.println();*/

        TreeNode head2 = transfer.solution2(root);
        System.out.println();

    }

}
