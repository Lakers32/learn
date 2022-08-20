package com.example.learn.algorithm.leetcode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 */
public class SwapPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归法
     *
     * @param head
     * @return
     */
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = solution(newHead.next);
        newHead.next = head;

        return newHead;
    }

    /**
     * 迭代法
     * 增加虚拟节点，方便迭代
     */
    public ListNode solution2(ListNode head) {
        // 增加虚拟节点，并将当前节点置位虚拟节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = dummyHead;

        // 长度奇数停止条件current.next.next != null，长度偶数停止条件current.next != null
        while (current.next != null && current.next.next != null) {
            // 暂存节点
            ListNode node1 = current.next;
            ListNode node2 = current.next.next;

            // 交换，先执行node1.next = node2.next;否则无法执行node2.next = node1;
            current.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            // 前进两位（node1与node2已经交换，故下面操作就可以了）
            current = node1;
        }

        return dummyHead.next;
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
        SwapPairs swapPairs = new SwapPairs();
        head = swapPairs.solution2(head);
        print(head);
    }

}
