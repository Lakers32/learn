package com.example.learn.algorithm.classic;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: DetectCycleInLinkedList
 * @Description: 面试题 02.08. 环路检测
 * <p>
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * @Author: kotchen
 * @Date: 2021/3/14 12:24
 * @Version: 1.0
 **/
public class DetectCycleInLinkedList {

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
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();

        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }

        return null;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public static ListNode solution2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            // 当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr 指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;

        System.out.println("The entrance of the circle in linked list is " + solution(node2).val);
    }
}
