package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * @author: cheng kai
 * @create: 2021-03-06 18:21
 **/
public class LowestCommonAncestorInBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 迭代法（后序遍历）
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = solution(root.left, p, q);
        TreeNode right = solution(root.right, p, q);

        // 1、说明 root 的左 / 右子树中都不包含 p,q ，返回 null
        if (left == null && right == null) {
            return null;
        }
        // 3、当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
        // ①、p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
        // ②、p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点
        if (left == null) {
            return right;
        }
        // 4、当 left 不为空 ， right 为空 ：与情况 3. 同理
        if (right == null) {
            return left;
        }
        // 2、说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        System.out.println("Lowest common ancestor in binary search tree is " + solution(root, p, q).val);
    }
}
