package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 04.05. 合法二叉搜索树
 * <p>
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * <p>
 * https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 * @author: cheng kai
 * @create: 2021-03-17 20:10
 **/
public class IsValidBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 利用JAVA内置最大值、小值进行递归
     *
     * @param root
     * @return
     */
    public static boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        return recur(root.left, Long.MIN_VALUE, root.val) && recur(root.right, root.val, Long.MAX_VALUE);
    }

    private static boolean recur(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }

        boolean left = recur(root.left, min, root.val);
        boolean right = recur(root.right, root.val, max);

        return left && right;
    }

    /**
     * 先找到根节点的最大、最小值，再递归逐个判断
     *
     * @param root
     * @return
     */
    public static boolean solution2(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode maxLeft = root.left, minRight = root.right;

        // 找寻左子树中的最右（数值最大）节点
        while (maxLeft != null && maxLeft.right != null) {
            maxLeft = maxLeft.right;
        }

        // 找寻右子树中的最左（数值最小）节点
        while (minRight != null && minRight.left != null) {
            minRight = minRight.left;
        }

        // 当前层是否合法
        boolean ret = (maxLeft == null || maxLeft.val < root.val) && (minRight == null || root.val < minRight.val);
        
        // 进入左子树和右子树并判断是否合法
        return ret && solution2(root.left) && solution2(root.right);
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

        System.out.println("Is valid BST? " + solution(root));
    }

}