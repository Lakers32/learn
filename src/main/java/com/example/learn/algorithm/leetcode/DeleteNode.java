package com.example.learn.algorithm.leetcode;

/**
 * 删除二叉搜索树中的节点
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * 链接：https://leetcode.cn/problems/delete-node-in-a-bst
 */
public class DeleteNode {

    /**
     * 递归法
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode solution(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }

        if (root.val > key) {
            root.left = solution(root.left, key);
        }
        if (root.val < key) {
            root.right = solution(root.right, key);
        }
        return root;
    }

    /**
     * 迭代法
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode solution2(TreeNode root, int key) {
        TreeNode cur = root, curParent = null;
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (cur == null) {
            return root;
        }
        if (cur.left == null && cur.right == null) {
            cur = null;
        } else if (cur.right == null) {
            cur = cur.left;
        } else if (cur.left == null) {
            cur = cur.right;
        } else {
            TreeNode successor = cur.right, successorParent = cur;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            if (successorParent.val == cur.val) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;
        }
        if (curParent == null) {
            return cur;
        } else {
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {
                curParent.right = cur;
            }
            return root;
        }
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

        DeleteNode deleteNode = new DeleteNode();
        int key = 7;
        System.out.println("Delete Node " + deleteNode.solution(root, key));
    }

}
