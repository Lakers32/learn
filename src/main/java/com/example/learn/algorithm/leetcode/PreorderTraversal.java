package com.example.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */
public class PreorderTraversal {

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // 中
        result.add(root.val);
        // 左
        preorder(root.left, result);
        // 右
        preorder(root.right, result);
    }

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 中
            result.add(node.val);
            // 右
            if (node.right != null) {
                stack.push(node.right);
            }
            // 左
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
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

        PreorderTraversal traversal = new PreorderTraversal();
        System.out.println("Preorder Traversal Recurrence " + traversal.solution(root));

        System.out.println("Preorder Traversal Iteration  " + traversal.solution2(root));
    }

}
