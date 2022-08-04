package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 02.03. 删除中间节点
 * <p>
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 * @author: cheng kai
 * @create: 2021-03-10 17:34
 **/
public class DeleteNodeInLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 将下一个节点的val复制到本节点，然后将本节点指向下下个节点
     *
     * @param node
     */
    public static void solution(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        solution(node2);
        System.out.println();
    }

}
