package com.example.learn.algorithm.sword;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 剑指 Offer 34. 二叉树中和为某一值的路径
 * <p>
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @author: cheng kai
 * @create: 2021-02-23 11:26
 **/
public class SumIsRootPathInBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 所有路径列表，全局变量
     */
    LinkedList<List<Integer>> pathList = new LinkedList<>();
    /**
     * 路径列表，全局变量
     */
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 回溯法
     * 查找路径一般都用回溯法？
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> solution(TreeNode root, int sum) {
        recur(root, sum);
        return pathList;
    }

    private void recur(TreeNode root, int latestSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);

        // 计算最新sum
        latestSum -= root.val;

        // 退出条件
        if (latestSum == 0 && root.left == null && root.right == null) {
            pathList.add(new LinkedList(path));
        }

        // 递归
        recur(root.left, latestSum);
        recur(root.right, latestSum);

        // 回溯，删除上一次递归结束后的path最后添加的元素
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        int sum = 22;
        SumIsRootPathInBinaryTree algs = new SumIsRootPathInBinaryTree();
        System.out.println("The path equals " + sum + " are " + algs.solution(root, sum));
    }

}
