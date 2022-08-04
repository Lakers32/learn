package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @author: cheng kai
 * @create: 2021-02-23 10:03
 **/
public class VerifyPostorderSeqInBinaryTreeSearch {

    public static boolean solution(int[] postorder) {
        if (postorder == null) {
            return true;
        }

        return recur(postorder, 0, postorder.length - 1);
    }

    private static boolean recur(int[] postorder, int begin, int end) {
        if (begin >= end) {
            return true;
        }

        // 第一次循环找到第一次大于根节点的索引，并保存在m中，继续循环直到不大于根节点
        int p = begin;
        while (postorder[p] < postorder[end]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[end]) {
            p++;
        }

        // p == end说明从第一次大于根节点的索引到根节点的值，均大于根节点，即二叉查找树右侧节点均大于根节点
        return p == end && recur(postorder, begin, m - 1) && recur(postorder, m, end - 1);
    }

    public static void main(String[] args) {
        int[] postorder1 = {1, 6, 3, 2, 5};
        int[] postorder2 = {1, 3, 2, 6, 5};
        int[] postorder3 = {1, 3, 2, 7, 6, 5};

        System.out.println("Verify postorder sequence in binary tree search? " + solution(postorder3));
    }
}
