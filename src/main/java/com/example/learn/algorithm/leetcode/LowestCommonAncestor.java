package com.example.learn.algorithm.leetcode;

/**
 * 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
 */
public class LowestCommonAncestor {

    /**
     * 从下往上递归，就要用到回溯，所以后续遍历
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        // 递归结束条件：叶子节点以下，或者找到p或者q
        if (root == null || root == p || root == q) {
            return root;
        }

        // 后序遍历
        TreeNode left = solution(root.left, p, q);
        TreeNode right = solution(root.right, p, q);

        // 若未找到节点 p 或 q
        if (left == null && right == null) {
            return null;
        }
        // 若找到一个节点，向上返回（回溯）
        else if (left == null && right != null) {
            return right;
        }
        // 若找到一个节点，向上返回（回溯）
        else if (left != null && right == null) {
            return left;
        }
        // 若找到两个节点，向上返回（回溯）
        else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode p = node3;
        TreeNode q = node4;
        System.out.println("Lowest Common Ancestor Is " + lowestCommonAncestor.solution(root, p, q));
    }
}
