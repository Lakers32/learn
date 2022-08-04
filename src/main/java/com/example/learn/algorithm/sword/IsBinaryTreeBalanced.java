package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 55 - II. 平衡二叉树
 * <p>
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @author: cheng kai
 * @create: 2021-03-04 10:27
 **/
public class IsBinaryTreeBalanced {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 后序遍历 + 剪枝 （从底至顶）
     * 此方法为本题的最优解法，但剪枝的方法不易第一时间想到。
     *
     * @param root
     * @return
     */
    public static boolean solution(TreeNode root) {
        return recur(root) != -1;
    }

    /**
     * 当节点root 左/右子树的深度差 ≤ 1 ：则返回当前子树的深度，即节点 root 的左/右子树的深度最大值 + 1，也就是（ max(left, right) + 1 ）；
     * 当节点root 左/右子树的深度差 > 2 ：则返回 −1（减枝），代表 此子树不是平衡树 。
     *
     * @param root
     * @return
     */
    private static int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }



    /**
     * 先序遍历 + 判断深度 （从顶至底）
     * 此方法容易想到，但会产生大量重复计算，时间复杂度较高。
     *
     * @param root
     * @return
     */
    public static boolean solution2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && solution2(root.left) && solution2(root.right);
    }

    /**
     * 计算二叉树的最大深度
     *
     * @param root
     * @return
     */
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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

        System.out.println("Is binary tree balanced? " + solution(root));
    }
}
