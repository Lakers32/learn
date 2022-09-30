package com.example.learn.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 找树左下角的值
 * <p>
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * <p>
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 * @author: 程凯
 * @create: 2022-09-30 22:30
 **/
public class FindBottomLeftValue {

    /**
     * 递归+回溯
     */
    private int maxDeep = -1;
    private int value = 0;

    public int solution(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    private void findLeftValue(TreeNode root, int deep) {
        // 两个if都是终止条件
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (deep > maxDeep) {
                // 每次都先访问左节点，过深度大于maxDeep的第一个节点就是目标所求
                value = root.val;
                maxDeep = deep;
            }
        }

        // 只有左右递归，中节点不做处理。deep，没有变化，暗含着回溯:递归前++1，递归后--1
        if (root.left != null) {
            findLeftValue(root.left, deep + 1);
        }
        if (root.right != null) {
            findLeftValue(root.right, deep + 1);
        }
    }

    /**
     * 遍历
     *
     * @param root
     * @return
     */
    public int solution2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // 本层中的第一个元素就是最左值
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        FindBottomLeftValue findBottomLeftValue = new FindBottomLeftValue();
        System.out.println("Find Bottom Left Value Is " + findBottomLeftValue.solution(root));
    }
}
