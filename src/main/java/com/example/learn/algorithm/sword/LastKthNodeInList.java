package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 22. 链表中倒数第k个节点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * @author: cheng kai
 * @create: 2021-02-21 09:45
 **/
public class LastKthNodeInList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode solution(ListNode head, int k) {
        if (k <= 0) {
            return null;
        }

        // 前面节点先走k步
        ListNode frontNode = head;
        int stepLength = 0;
        while (stepLength < k) {
            stepLength++;
            if (frontNode != null) {
                frontNode = frontNode.next;
            } else {
                return null;
            }

        }

        // 找到倒数第K个节点
        ListNode behindNode = head;
        while (frontNode != null) {
            frontNode = frontNode.next;
            behindNode = behindNode.next;
        }

        return behindNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println("Last 3 node is " + solution(node1, 3));
    }
}
