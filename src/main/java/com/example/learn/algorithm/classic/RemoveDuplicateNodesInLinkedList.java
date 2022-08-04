package com.example.learn.algorithm.classic;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 面试题 02.01. 移除重复节点
 * <p>
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * @author: cheng kai
 * @create: 2021-03-10 16:53
 **/
public class RemoveDuplicateNodesInLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 哈希表
     *
     * @param head
     * @return
     */
    public static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }

        Set<Integer> occurred = new HashSet<>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;

        return head;
    }

    /**
     * 两重循环
     *
     * @param head
     * @return
     */
    public static ListNode solution2(ListNode head) {
        ListNode ob = head;
        while (ob != null) {
            ListNode oc = ob;
            while (oc.next != null) {
                if (oc.next.val == ob.val) {
                    oc.next = oc.next.next;
                } else {
                    oc = oc.next;
                }
            }
            ob = ob.next;
        }

        return head;
    }

    /**
     * 位运算
     * 提示中有这样一句话“链表元素在[0, 20000]范围内”
     *
     * @param head
     * @return
     */
    public static ListNode solution3(ListNode head) {
        // 32位
        int[] bits = new int[20000 / 32 + 1];
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            bits[cur.val / 32] |= 1 << (cur.val % 32);
            if ((bits[cur.next.val / 32] & (1 << (cur.next.val % 32))) != 0) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = solution2(head);
        System.out.println();
    }

}
