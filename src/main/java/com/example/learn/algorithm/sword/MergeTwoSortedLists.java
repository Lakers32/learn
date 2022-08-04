package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 25. 合并两个排序的链表
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @author: cheng kai
 * @create: 2021-02-21 11:18
 **/
public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 得到首节点后，逐个添加到新链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode l = null;
        ListNode lHead = null;
        // 将l1、l2逐个添加到l中
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (l == null) {
                    l = new ListNode(l1.val);
                    lHead = l;
                } else {
                    lHead.next = new ListNode(l1.val);
                    lHead = lHead.next;
                }
                l1 = l1.next;
            } else {
                if (l == null) {
                    l = new ListNode(l2.val);
                    lHead = l;
                } else {
                    lHead.next = new ListNode(l2.val);
                    lHead = lHead.next;
                }
                l2 = l2.next;
            }
        }

        // 将剩余逐个添加到l中
        if (l1 != null) {
            lHead.next = l1;
        }
        if (l2 != null) {
            lHead.next = l2;
        }

        return l;
    }

    /**
     * 构建虚拟节点为首节点，返回第二个节点即可
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution2(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(Integer.MIN_VALUE);
        ListNode lHead = l;
        // 将l1、l2逐个添加到l中
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                lHead.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                lHead.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            lHead = lHead.next;
        }

        // 将剩余逐个添加到l中
        if (l1 != null) {
            lHead.next = l1;
        }
        if (l2 != null) {
            lHead.next = l2;
        }

        return l.next;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(5);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(4);
        ListNode node23 = new ListNode(6);
        node21.next = node22;
        node22.next = node23;

        System.out.println("The merged list is " + solution2(node11, node21));
    }
}
