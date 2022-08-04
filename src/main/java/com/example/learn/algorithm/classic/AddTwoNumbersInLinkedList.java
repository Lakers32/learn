package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 02.05. 链表求和
 * <p>
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 * https://leetcode-cn.com/problems/sum-lists-lcci/
 * @author: cheng kai
 * @create: 2021-03-10 21:00
 **/
public class AddTwoNumbersInLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 迭代法
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            //求两个节点相加的值
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            //取进位的值
            carry = sum / 10;
            //sum对10求余后放到节点中
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }

        return head.next;
    }

    /**
     * 递归法
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        helper(head, l1, l2, 0);
        return head.next;
    }

    private static void helper(ListNode result, ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return;
        }

        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
        result.next = new ListNode(0);
        result.next.val = sum % 10;
        carry = sum / 10;
        
        helper(result.next, l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
    }


    /**
     * 思考一下，假设这些数位是正向存放的，又该如何解决呢?
     * 链表反转 + 上述解决办法
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution3(ListNode l1, ListNode l2) {
        return reverseList(solution2(reverseList(l1), reverseList(l2)));
    }

    /**
     * 反转单链表
     *
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
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


    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(6);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(2);
        l2.next = l21;
        l21.next = l22;

        ListNode nodeSum = solution2(l1, l2);

        System.out.println("上面是低位在链表前面，高位在链表后面。下面是高位在链表前面，高位在链表后面。");

        ListNode ll1 = new ListNode(6);
        ListNode ll11 = new ListNode(1);
        ListNode ll12 = new ListNode(7);
        ll1.next = ll11;
        ll11.next = ll12;

        ListNode ll2 = new ListNode(2);
        ListNode ll21 = new ListNode(9);
        ListNode ll22 = new ListNode(5);
        ll2.next = ll21;
        ll21.next = ll22;

        ListNode reservedNodeSum = solution3(ll1, ll2);
        System.out.println();
    }

}
