package com.example.learn.algorithm.leetcode;

/**
 * 把二叉搜索树转换为累加树
 * <p>
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。 节点的右子树仅包含键 大于 节点键的节点。 左右子树也必须是二叉搜索树。
 * <p>
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 */
public class ConvertBST {

    int sum;

    public TreeNode solution(TreeNode root) {
        sum = 0;
        convertBST(root);
        return root;
    }

    /**
     * 按右中左顺序遍历，累加即可
     *
     * @param root
     */
    public void convertBST(TreeNode root) {
        if (root == null) {
            return;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
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

        ConvertBST convertBST = new ConvertBST();
        System.out.println("Convert BST" + convertBST.solution(root));
    }
}
