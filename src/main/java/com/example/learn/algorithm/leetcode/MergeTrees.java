package com.example.learn.algorithm.leetcode;

import java.util.Stack;

/**
 * @description: 合并二叉树
 *
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 * 链接：https://leetcode.cn/problems/merge-two-binary-trees
 *
 * @author: 程凯
 * @create: 2022-10-03 11:12
 **/
public class MergeTrees {

    /**
     * 递归法：前中后序都可以
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode solution(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;
        root1.left = solution(root1.left,root2.left);
        root1.right = solution(root1.right,root2.right);

        return root1;
    }

    /**
     * 迭代法
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode solution2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root2);
        stack.push(root1);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            node1.val += node2.val;
            if (node2.right != null && node1.right != null) {
                stack.push(node2.right);
                stack.push(node1.right);
            } else {
                if (node1.right == null) {
                    node1.right = node2.right;
                }
            }
            if (node2.left != null && node1.left != null) {
                stack.push(node2.left);
                stack.push(node1.left);
            } else {
                if (node1.left == null) {
                    node1.left = node2.left;
                }
            }
        }

        return root1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node11 = new TreeNode(9);
        TreeNode node12 = new TreeNode(9);
        TreeNode node13 = new TreeNode(15);
        TreeNode node14 = new TreeNode(15);

        node1.left = node11;
        node1.right = node12;
        node11.left = node13;
        node11.right = node14;

        TreeNode node2 = new TreeNode(3);
        TreeNode node21 = new TreeNode(9);
        TreeNode node22 = new TreeNode(9);
        TreeNode node23 = new TreeNode(15);
        TreeNode node24 = new TreeNode(15);

        node21.left = node21;
        node21.right = node22;
        node22.left = node23;
        node22.right = node24;

        MergeTrees mergeTrees = new MergeTrees();
        System.out.println("Merge Trees is " + mergeTrees.solution(node1, node2));
    }
}
