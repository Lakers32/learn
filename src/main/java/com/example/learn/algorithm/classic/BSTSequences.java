package com.example.learn.algorithm.classic;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 面试题 04.09. 二叉搜索树序列
 * <p>
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
 * <p>
 * https://leetcode-cn.com/problems/bst-sequences-lcci/
 * @author: cheng kai
 * @create: 2021-03-18 09:33
 **/
public class BSTSequences {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

/*
    全排列三板斧：
    //定义好结果集
    List<...> res = ...
    void dfs(int level,...){
        //1.设定终止条件
        if(level达到遍历的最高层数) ....return;

        //2.对当前层数能够访问的元素进行遍历
        for(){
        ...
            //3.1 最关键的一步，设定访问标记，防止重复访问
            dfs(level+1,访问标记数组);
            //3.2 擦除访问标记
        }

    }
*/

/*
    回溯三部曲：
    1、确定回溯函数返回值以及参数(因为一般都是遍历整棵树，所有回溯返回值一般为void))
    2、确定回溯函数终止条件
    3、确定回溯函数的遍历过程
    void backtracking(参数) {
        if (终止条件) {
            存放结果;
            return;
        }

        for (选择：本层集合中元素) {
            处理结点;
            backtracking(路径，选择列表)); // 递归
            回溯，撤销处理结果;
        }
    }
*/

    private LinkedList<Integer> path = new LinkedList<>();
    private List<List<Integer>> result = new LinkedList<>();

    /**
     * 全排列的变形
     *
     * @param root
     * @return
     */
    public List<List<Integer>> solution(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        if (root != null) {
            dq.offer(root);
        }

        dfs(dq);

        return result;
    }

    public void dfs(Deque<TreeNode> dq) {
        // 确定递归终止条件：dq是该层剩下可选节点的候选队列，若队列为空，则说明没有候选元素了
        if (dq.isEmpty()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 当前层可与选择的候选节点的个数
        int size = dq.size();
        while (size > 0) {
            TreeNode cur = dq.pollFirst();
            // 向路径中添加当前值
            path.add(cur.val);
            // 记录添加的子节点数量，等会回溯时需要用
            int children = 0;
            // 向候选队列中添加子节点
            if (cur.left != null) {
                children++;
                dq.offerLast(cur.left);
            }
            if (cur.right != null) {
                children++;
                dq.offerLast(cur.right);
            }

            // 递归
            dfs(dq);

            // 回溯候选队列
            while (children > 0) {
                dq.pollLast();
                children--;
            }
            dq.offerLast(cur);

            // 回溯路径
            path.removeLast();
            // 当前节点处理完毕，数量减一
            size--;
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

        BSTSequences sequences = new BSTSequences();

        System.out.println("Permutation Sequence are " + sequences.solution(root));
    }
}
