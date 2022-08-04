package com.example.learn.algorithm.sword;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 剑指 Offer 55 - I. 二叉树的深度
 * <p>
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @author: cheng kai
 * @create: 2021-03-03 15:49
 **/
public class MaxDepthInBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 后序遍历（DFS）
     * 关键点： 此树的深度和其左（右）子树的深度之间的关系。显然，此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 + 1。
     *
     * @param root
     * @return
     */
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(solution(root.left), solution(root.right)) + 1;
    }

    /**
     * 层序遍历（BFS）
     * 关键点： 每遍历一层，则计数器 + 1，直到遍历完成，则可得到树的深度。
     *
     * @param root
     * @return
     */
    public static int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        // 临时存放本层的节点，并赋值给 queue
        List<TreeNode> tmp;
        int depth = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            queue = tmp;
            depth++;
        }

        return depth;
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

        System.out.println("The max depth is " + solution2(root));
    }
}
