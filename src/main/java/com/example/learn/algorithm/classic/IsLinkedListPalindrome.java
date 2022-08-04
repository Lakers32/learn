package com.example.learn.algorithm.classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 面试题 02.06. 回文链表
 * <p>
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 * @author: cheng kai
 * @create: 2021-03-10 21:55
 **/
public class IsLinkedListPalindrome {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 将值复制到数组中后用双指针法
     *
     * @param head
     * @return
     */
    public static boolean solution(ListNode head) {
        List<Integer> nodeList = new ArrayList<>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            nodeList.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = nodeList.size() - 1;
        while (front < back) {
            if (!nodeList.get(front).equals(nodeList.get(back))) {
                return false;
            }
            front++;
            back--;
        }

        return true;
    }

    /**
     * 递归法 全局前置节点
     */
    private static ListNode frontPointer;

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static boolean solution2(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private static boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public static boolean solution3(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 反转链表 + 逐个比对
     *
     * @param head
     * @return
     */
    public static boolean solution4(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode copyHead = copyList(head);
        ListNode reversedHead = reverseList(head);
        while (copyHead != null && reversedHead != null) {
            if (copyHead.val != reversedHead.val) {
                return false;
            }
            copyHead = copyHead.next;
            reversedHead = reversedHead.next;
        }

        return true;
    }

    private static ListNode copyList(ListNode node) {
        // todo
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(11);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println("Is linked list palindrome? " + solution4(head));
    }

}
