package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 52. 两个链表的第一个公共节点
 * @author: cheng kai
 * @create: 2021-03-02 17:37
 **/
public class FirstIntersectionNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 假设第一个公共节点为 node
     * ①、指针 A 先遍历完链表 headA ，再开始遍历链表 headB ，走到第一个公共节点 node
     * ②、指针 B 先遍历完链表 headB ，再开始遍历链表 headA ，走到第一个公共节点 node
     * 二者经历的步长相等，也就是说当 指针 A == 指针 B 时，就是第一个公共节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode solution(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }

        return A;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode A1 = new ListNode(1);
        headA.next = A1;

        ListNode headB = new ListNode(5);
        ListNode B1 = new ListNode(0);
        ListNode B2 = new ListNode(1);
        headB.next = B1;
        B1.next = B2;

        ListNode intersection1 = new ListNode(8);
        ListNode intersection2 = new ListNode(4);
        ListNode intersection3 = new ListNode(5);
        intersection1.next = intersection2;
        intersection2.next = intersection3;

        A1.next = intersection1;
        B2.next = intersection1;

        ListNode firstIntersectionNode = solution(headA, headB);
        System.out.println("The intersection node is " + firstIntersectionNode);
    }
}
