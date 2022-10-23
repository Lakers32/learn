package com.example.learn.algorithm.leetcode;

/**
 * 修剪二叉搜索树
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在唯一的答案。
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/trim-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TrimBST {

    public TreeNode solution(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // 删除节点就是返回子节点
        if (root.val < low) {
            return solution(root.right, low, high);
        }
        if (root.val > high) {
            return solution(root.left, low, high);
        }

        // root在[low,high]范围内
        root.left = solution(root.left, low, high);
        root.right = solution(root.right, low, high);
        return root;
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

        TrimBST trimBST = new TrimBST();
        int low = 9, high = 15;
        System.out.println("TrimBST " + trimBST.solution(root, low, high));
    }
}
