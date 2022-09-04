package com.example.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {

    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> solution(TreeNode root) {
        //checkFun01(root,0);
        checkFun02(root);

        return resList;
    }

    /**
     * DFS--递归方式
     *
     * @param node
     * @param deep
     */
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) {
            return;
        }

        deep++;
        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }

    /**
     * BFS--迭代方式--借助队列
     *
     * @param node
     */
    public void checkFun02(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            // 本层的节点个数
            int len = que.size();
            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                len--;
            }

            resList.add(itemList);
        }

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

        LevelOrder levelOrder = new LevelOrder();
        System.out.println("LevelOrder " + levelOrder.solution(root));
    }
}
