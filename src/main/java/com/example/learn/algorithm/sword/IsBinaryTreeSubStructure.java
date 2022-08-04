package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 26. 二叉树的子结构
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * @author: cheng kai
 * @create: 2021-02-21 14:43
 **/
public class IsBinaryTreeSubStructure {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 先序遍历A
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        // 当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true ；
        if(B == null) {
            return true;
        }
        // 当节点 AA 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false ；当节点 A 和 B 的值不同：说明匹配失败，返回 false ；
        if(A == null || A.val != B.val) {
            return false;
        }
        // 继续判断左右节点是否相等
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        TreeNode A1 = new TreeNode(4);
        TreeNode A2 = new TreeNode(5);
        TreeNode A3 = new TreeNode(1);
        TreeNode A4 = new TreeNode(2);
        A.left = A1;
        A.right = A2;
        A1.left = A3;
        A1.right = A4;

        TreeNode B = new TreeNode(4);
        TreeNode B1 = new TreeNode(1);
        B.left = B1;

        IsBinaryTreeSubStructure subStructure = new IsBinaryTreeSubStructure();
        System.out.println("Is B a sub of A? " + subStructure.isSubStructure(A, B));
    }

}
