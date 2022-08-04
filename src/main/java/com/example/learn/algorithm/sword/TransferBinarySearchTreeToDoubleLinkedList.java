package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 36. 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
 * @author: cheng kai
 * @create: 2021-02-23 14:17
 **/
public class TransferBinarySearchTreeToDoubleLinkedList {

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /**
     * pre：前置节点，也是尾节点
     * head：头节点，也是后置节点
     */
    Node pre, head;

    public Node solution(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 递归法中序遍历
     * @param cur
     */
    void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        // pre不为空，说明是递归中的归操作
        if (pre != null) {
            // 类似双向链表中的前置节点
            pre.right = cur;
        }
        // pre仍旧是null，说明访问到了头节点
        else {
            head = cur;
        }
        // 类似双向链表中的后置节点
        cur.left = pre;
        // 保存cur给pre备用
        pre = cur;
        dfs(cur.right);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(1);
        Node node4 = new Node(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        TransferBinarySearchTreeToDoubleLinkedList transfer = new TransferBinarySearchTreeToDoubleLinkedList();
        Node head = transfer.solution(root);
        System.out.println();
    }

}
