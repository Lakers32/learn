package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 02.04. 分割链表
 * <p>
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
 * 分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * <p>
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * @author: cheng kai
 * @create: 2021-03-10 18:19
 **/
public class RecombineLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 模拟
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode solution(ListNode head, int x) {
        // 初始化大于和小于x的链表，头节点是虚拟的
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        solution(head, 5);
        System.out.println();
    }
}
