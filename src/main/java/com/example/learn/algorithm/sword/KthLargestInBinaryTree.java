package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 54. 二叉搜索树的第k大节点
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @author: cheng kai
 * @create: 2021-03-03 14:33
 **/
public class KthLargestInBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int k = 0, val = 0;

    /**
     * 二叉搜索树的中序遍历为 递增序列
     * 根据以上性质，易得二叉搜索树的 中序遍历倒序 为 递减序列
     * 因此，求 “二叉搜索树第 k 大的节点” 可转化为求 “此树的中序遍历倒序的第 k 个节点”
     *
     * @param root
     * @param k
     * @return
     */
    public int solution(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return val;
    }

    /**
     * 按照右、中、左顺序逆序深度遍历二叉树
     *
     * @param root
     */
    public void dfs(TreeNode root) {
        if (root == null || k == 0) {
            return;
        }
        dfs(root.right);
        if (--k == 0) {
            val = root.val;
            return;
        }
        dfs(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;

        int k = 3;
        KthLargestInBinaryTree function = new KthLargestInBinaryTree();
        System.out.println("The " + k + "th largest number is " + function.solution(root, k));
    }
}
