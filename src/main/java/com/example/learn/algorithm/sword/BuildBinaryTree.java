package com.example.learn.algorithm.sword;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: 剑指 Offer 07. 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 *
 * @author: cheng kai
 * @create: 2021-02-04 18:54
 **/
public class BuildBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归法
     * 二叉树的前序遍历顺序是：根节点、左子树、右子树，每个子树的遍历顺序同样满足前序遍历顺序。
     * 二叉树的中序遍历顺序是：左子树、根节点、右子树，每个子树的遍历顺序同样满足中序遍历顺序。
     * 前序遍历的第一个节点是根节点，只要找到根节点在中序遍历中的位置，
     * 在根节点之前被访问的节点都位于左子树，在根节点之后被访问的节点都位于右子树，由此可知左子树和右子树分别有多少个节点。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode solution(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        // 将中序的内容按照<val， index>形式存储
        Map<Integer, Integer> indexMap = new HashMap<>(16);
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }

        // 递归调用
        TreeNode root = solution(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);

        return root;
    }

    public static TreeNode solution(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        // 也可以用inorderStart和inorderEnd判断，只不过前序正好能够获得分支根节点
        if (preorderStart > preorderEnd) {
            return null;
        }
        // 分支前序遍历起始位置肯定是分支根节点,rootVal是先序和中序桥梁
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart < preorderEnd) {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = solution(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = solution(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
        }

        return root;
    }

    /**
     * 迭代法
     * 使用栈保存遍历过的节点。初始时令中序遍历的指针指向第一个元素，遍历前序遍历的数组，
     * 如果前序遍历的元素不等于中序遍历的指针指向的元素，则前序遍历的元素为上一个节点的左子节点。
     * 如果前序遍历的元素等于中序遍历的指针指向的元素，则正向遍历中序遍历的元素同时反向遍历前序遍历的元素，
     * 找到最后一次相等的元素，将前序遍历的下一个节点作为最后一次相等的元素的右子节点。
     * 其中，反向遍历前序遍历的元素可通过栈的弹出元素实现。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode solution2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int[] inorder = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        TreeNode root = solution2(preorder, inorder);

        // 按层打印二叉树
        System.out.println();
    }
}
