package com.example.learn.algorithm.leetcode;

import java.util.Stack;

/**
 * @description: 二叉搜索树中的搜索
 * <p>
 * 给定二叉搜索树（BST）的根节点root和一个整数值val。
 * 你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。
 * <p>
 * 链接：https://leetcode.cn/problems/search-in-a-binary-search-tree
 * @author: 程凯
 * @create: 2022-10-03 11:33
 **/
public class SearchBST {

    /**
     * 递归，普通二叉树
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode solution(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        TreeNode left = solution(root.left, val);
        if (left != null) {
            return left;
        }

        return solution(root.right, val);
    }

    /**
     * 递归，利用二叉搜索树特点，优化
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode solution2(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return solution2(root.left, val);
        } else {
            return solution2(root.right, val);
        }
    }

    /**
     * 迭代，普通二叉树
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode solution3(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.val == val) {
                return pop;
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        return null;
    }

    /**
     * 迭代，利用二叉搜索树特点，优化，可以不需要栈
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode solution4(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        SearchBST searchBST = new SearchBST();
        int val = 1;
        System.out.println("Search BST is " + searchBST.solution4(root, val));
    }

}
