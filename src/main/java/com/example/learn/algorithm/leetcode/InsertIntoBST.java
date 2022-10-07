package com.example.learn.algorithm.leetcode;

/**
 * @description: 二叉搜索树中的插入操作
 * <p>
 * 给定二叉搜索树（BST）的根节点root和要插入树中的值value，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * <p>
 * 链接：https://leetcode.cn/problems/insert-into-a-binary-search-tree
 * @author: 程凯
 * @create: 2022-10-07 21:20
 **/
public class InsertIntoBST {

    /**
     * 递归法：将插入节点放在叶子节点下面
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode solution(TreeNode root, int val) {
        // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            // 递归创建右子树
            root.right = solution(root.right, val);
        } else if (root.val > val) {
            // 递归创建左子树
            root.left = solution(root.left, val);
        }

        return root;
    }


    /**
     * 迭代法：将插入节点放在叶子节点下面
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode solution2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode newRoot = root;
        TreeNode pre = root;
        while (root != null) {
            pre = root;
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            }
        }

        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }

        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        InsertIntoBST insertIntoBST = new InsertIntoBST();
        int val = 1;
        System.out.println("Insert Into BST " + insertIntoBST.solution(root, val));
    }
}
