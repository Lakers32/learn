package com.example.learn.algorithm.sword;

/**
 * @description: 二叉搜索树的最近公共祖先
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * @author: cheng kai
 * @create: 2021-03-06 17:16
 **/
public class LowestCommonAncestorInBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 迭代
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // 保证 p.val < q.val
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        // root肯定是公共祖先
        while (root != null) {
            // p,q 都在 root 的右子树中
            if (root.val < p.val) {
                // 遍历至右子节点
                root = root.right;
            }
            // p,q 都在 root 的左子树中
            else if (root.val > q.val) {
                // 遍历至左子节点
                root = root.left;
            } else {
                // p在左，q在右，说明找到了 最近公共祖先 ，跳出
                break;
            }
        }

        return root;
    }

    /**
     * 递归
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        return recur(root, p, q);
    }

    private static TreeNode recur(TreeNode root, TreeNode p, TreeNode q) {
        // p,q 都在 root 的右子树中
        if (root.val < p.val && root.val < q.val) {
            return solution2(root.right, p, q);
        }
        // p,q 都在 root 的左子树中
        if (root.val > p.val && root.val > q.val) {
            return solution2(root.left, p, q);
        }

        // 说明p,q 在root.val两侧，即找到了 最近公共祖先 ，跳出
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;

        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(5);

        System.out.println("Lowest common ancestor in binary search tree is " + solution(root, p, q).val);
    }

}

