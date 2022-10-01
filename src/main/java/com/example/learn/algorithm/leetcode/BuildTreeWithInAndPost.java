package com.example.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 从中序与后序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * @author: 程凯
 * @create: 2022-10-01 11:31
 **/
public class BuildTreeWithInAndPost {

    /**
     * 方便根据数值查找位置
     */
    Map<Integer, Integer> map;

    public TreeNode solution(int[] inorder, int[] postorder) {
        map = new HashMap<>(16);
        // 用map保存中序序列的数值对应位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // 前闭后开
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // 参数里的范围都是前闭后开
        // 不满足左闭右开，说明没有元素，返回空树
        if (inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }
        // 找到后序遍历的最后一个元素在中序遍历中的位置
        int rootIndex = map.get(postorder[postEnd - 1]);
        // 构造结点
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 保存中序左子树个数，用来确定后序数列的个数
        int lenOfLeft = rootIndex - inBegin;
        root.left = findNode(inorder, inBegin, rootIndex,
                postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7}, postorder = {9, 15, 7, 20, 3};

        BuildTreeWithInAndPost buildTreeWithInAndPost = new BuildTreeWithInAndPost();
        TreeNode root = buildTreeWithInAndPost.solution(inorder, postorder);
        System.out.println("Build Tree With In And Post " + root);
    }
}
