package com.example.learn.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 完全二叉树的节点个数
 * <p>
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 链接：https://leetcode.cn/problems/count-complete-tree-nodes
 * @author: 程凯
 * @create: 2022-09-11 11:20
 **/
public class CountNodes {

    /**
     * 普通二叉树通用递归解法:后序
     *
     * @param root
     * @return
     */
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return solution(root.left) + solution(root.right) + 1;
    }

    /**
     * 普通二叉树通用递归解法:迭代法
     *
     * @param root
     * @return
     */
    public int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                result++;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        return result;
    }

    /**
     * 针对完全二叉树的解法
     * <p>
     * 满二叉树的结点数为：2^depth - 1
     */
    public int solution3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        // 左子树是满二叉树
        if (leftDepth == rightDepth) {
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (1 << leftDepth) + solution3(root.right);
        }
        // 右子树是满二叉树
        else {
            return (1 << rightDepth) + solution3(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
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

        CountNodes countNodes = new CountNodes();
        System.out.println("Count nodes is " + countNodes.solution3(root));
    }
}
