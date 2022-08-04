package com.example.learn.algorithm.sword;

import java.util.*;

/**
 * @description: 剑指 Offer 32-III. 从上到下打印二叉树 III（按层打印二叉树）
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * @author: cheng kai
 * @create: 2021-02-22 15:42
 **/
public class PrintBinaryTreeByLevel3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 层序遍历 + 双端队列
     * 奇数层 则将节点数值添加至该层链表尾部，
     * 偶数层 则将节点数值添加至该层链表头部。
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> solution(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> levelVales = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> vales = new LinkedList<>();
            // 一次while循环中，队列queue中均为本层的数值
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                // levelVales中的个数即是层数
                if (levelVales.size() % 2 == 0) {
                    vales.addLast(node.val);
                } else {
                    vales.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            levelVales.add(vales);
        }

        return levelVales;
    }

    /**
     * 层序遍历 + 双端队列（奇偶层逻辑分离）
     * 方法一代码简短、容易实现；但需要判断每个节点的所在层奇偶性，即冗余了N次判断。
     * 通过将奇偶层逻辑拆分，可以消除冗余的判断。
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> solution2(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> levelVales = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            // 打印奇数层
            List<Integer> vales = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                vales.add(node.val);
                // 先左后右加入下层节点
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            levelVales.add(vales);

            // 若为空则提前跳出
            if (deque.isEmpty()) {
                break;
            }

            // 打印偶数层
            vales = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                vales.add(node.val);
                // 先右后左加入下层节点
                if (node.right != null) {
                    deque.addFirst(node.right);
                }
                if (node.left != null) {
                    deque.addFirst(node.left);
                }
            }
            levelVales.add(vales);
        }
        return levelVales;
    }

    /**
     * 此方法的优点是只用列表即可，无需其他数据结构。
     * 偶数层倒序：若res的长度为奇数，说明当前是偶数层，则对vales执行倒序操作。
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> solution3(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> levelVales = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> vales = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                vales.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (levelVales.size() % 2 == 1) {
                Collections.reverse(vales);
            }
            levelVales.add(vales);
        }

        return levelVales;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println("Print binary tree by level: " + (solution2(root)));
    }
}
