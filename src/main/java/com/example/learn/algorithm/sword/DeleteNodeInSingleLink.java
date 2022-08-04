package com.example.learn.algorithm.sword;


/**
 * @description: 剑指 Offer 18. 删除链表的节点
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * <p>
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @author: cheng kai
 * @create: 2021-02-20 11:55
 **/
public class DeleteNodeInSingleLink {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 双指针
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode solution(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode previousNode = head;
        ListNode currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.val == val) {
                previousNode.next = currentNode.next;
                currentNode.next = null;
                break;
            }
            previousNode = previousNode.next;
            currentNode = currentNode.next;
        }
        return head;
    }

    /**
     * 单指针
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode solution2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode currentNode = head;
        while (currentNode.next != null && currentNode.next.val != val) {
            currentNode = currentNode.next;
        }
        if (currentNode.next != null) {
            currentNode.next = currentNode.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(4);
        ListNode list2 = new ListNode(5);
        ListNode list3 = new ListNode(1);
        ListNode list4 = new ListNode(9);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;

        System.out.println("delete 0" + solution(list1, 5));
        System.out.println("delete 5" + solution2(list1, 1));
    }
}
