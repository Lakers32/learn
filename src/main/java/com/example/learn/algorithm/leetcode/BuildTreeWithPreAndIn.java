package com.example.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 从前序与中序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * @author: 程凯
 * @create: 2022-10-01 11:34
 **/
public class BuildTreeWithPreAndIn {

    Map<Integer, Integer> map;

    public TreeNode solution(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        // 用map保存中序序列的数值对应位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // 前闭后开
        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        // 参数里的范围都是前闭后开
        // 不满足左闭右开，说明没有元素，返回空树
        if (preBegin >= preEnd || inBegin >= inEnd) {
            return null;
        }

        // 找到前序遍历的第一个元素在中序遍历中的位置
        int rootIndex = map.get(preorder[preBegin]);
        // 构造结点
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 保存中序左子树个数，用来确定前序数列的个数
        int lenOfLeft = rootIndex - inBegin;
        root.left = findNode(preorder, preBegin + 1, preBegin + lenOfLeft + 1,
                inorder, inBegin, rootIndex);
        root.right = findNode(preorder, preBegin + lenOfLeft + 1, preEnd,
                inorder, rootIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};

        BuildTreeWithPreAndIn buildTreeWithPreAndIn = new BuildTreeWithPreAndIn();
        TreeNode root = buildTreeWithPreAndIn.solution(preorder, inorder);
        System.out.println("Build Tree With Pre And In " + root);
    }

}
