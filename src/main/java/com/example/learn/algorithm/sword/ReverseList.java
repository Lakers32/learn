package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 06. 从尾到头打印链表
 *
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author: cheng kai
 * @create: 2021-02-04 09:25
 **/
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归从尾到头逆转链表
     *
     * @param head
     * @return
     */
    public static ListNode solution(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode current = head;
        ListNode next = current.next;
        head = solution(next);

        next.next = current;
        current.next = null;
        return head;
    }

    /**
     * 遍历从尾到头逆转链表
     *
     * @param head
     * @return
     */
    public static ListNode solution2(ListNode head) {
        // 前面或当前节点
        ListNode current = null;
        // 后面和暂存节点
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = current;
            current = head;
            head = next;
        }

        return current;
    }

    private static void print(ListNode head) {
        String vals = "";
        while (head != null) {
            vals += head.val + ", ";
            head = head.next;
        }

        System.out.println("ListNode vals are " + vals.substring(0, vals.length() - 2));
    }

    public static void main(String[] args) {
        // 初始化
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        print(head);

        System.out.println();

        // 从尾到头打印链表
        head = solution2(head);
        print(head);

    }


}
