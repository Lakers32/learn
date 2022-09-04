package com.example.learn.algorithm.leetcode;

import java.util.ArrayDeque;

/**
 * 翻转二叉树
 * <p>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * https://leetcode.cn/problems/invert-binary-tree/
 */
public class InvertTree {

    /**
     * 针对二叉树的问题，解题之前一定要想清楚究竟是前中后序遍历，还是层序遍历。
     * 二叉树解题的大忌就是自己稀里糊涂的过了（因为这道题相对简单），但是也不知道自己是怎么遍历的。
     * 这也是造成了二叉树的题目“一看就会，一写就废”的原因。
     * 针对翻转二叉树，我给出了一种递归，三种迭代（两种模拟深度优先遍历，一种层序遍历）的写法，都是之前我们讲过的写法，融汇贯通一下而已。
     */

    /**
     * 前后序遍历都可以
     * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
     */
    public TreeNode solution(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 前序 swapChildren(root);
        solution(root.left);
        solution(root.right);
        // 后序
        swapChildren(root);

        return root;
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public TreeNode solution2(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                swapChildren(node);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }

        return root;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public TreeNode solution3(TreeNode root) {
        if (root == null) {
            return null;
        }

        solution(root.left);
        swapChildren(root);
        solution(root.right);

        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
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

        InvertTree invertTree = new InvertTree();
        System.out.println("Invert Tree " + invertTree.solution(root));
    }
}
