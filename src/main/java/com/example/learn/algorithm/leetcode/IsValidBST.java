package com.example.learn.algorithm.leetcode;

import java.util.Stack;

/**
 * @description: 验证二叉搜索树
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 链接：https://leetcode.cn/problems/validate-binary-search-tree
 * @author: 程凯
 * @create: 2022-10-03 15:51
 **/
public class IsValidBST {


    /**
     * 前一个节点，记录最大值
     */
    TreeNode max;

    /**
     * 递归 + 双指针
     *
     * @param root
     * @return
     */
    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 左
        boolean left = solution(root.left);
        if (!left) {
            return false;
        }

        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;

        // 右
        boolean right = solution(root.right);
        return right;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public boolean solution2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                // 左
                root = root.left;
            }
            // 中，处理
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;

            // 右
            root = pop.right;
        }

        return true;
    }

    /**
     * 简洁实现·递归解法
     *
     * @param root
     * @return
     */
    public boolean solution3(TreeNode root) {
        return validBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    boolean validBST(long lower, long upper, TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }

        return validBST(lower, root.val, root.left) && validBST(root.val, upper, root.right);
    }

    private long prev = Long.MIN_VALUE;

    /**
     * 简洁实现·递归解法
     *
     * @param root
     * @return
     */
    public boolean solution4(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!solution4(root.left)) {
            return false;
        }
        // 不满足二叉搜索树条件
        if (root.val <= prev) {
            return false;
        }
        prev = root.val;
        return solution4(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(15);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        IsValidBST isValidBST = new IsValidBST();
        System.out.println("Is Valid BST? " + isValidBST.solution(root));
    }
}
