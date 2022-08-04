package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 04.06. 后继者
 * <p>
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * https://leetcode-cn.com/problems/successor-lcci/
 * @author: cheng kai
 * @create: 2021-03-17 20:37
 **/
public class InorderSuccessorInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 问题的本质是找到最靠近p节点且值大于p节点值的那个节点
     *
     * @param root
     * @param p
     * @return
     */
    public static TreeNode solution(TreeNode root, TreeNode p) {
        TreeNode pre = null;

        while (root.val != p.val) {
            //右边
            if (p.val > root.val) {
                root = root.right;
            }
            //左边
            else {
                pre = root;
                root = root.left;
            }
        }

        // 假如没有右子树
        if (root.right == null) {
            return pre;
        } else {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }
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

        TreeNode p = new TreeNode(3);

        System.out.println("Inorder successor is " + (solution(root, p) == null ? -1 : solution(root, p).val));
    }

}
