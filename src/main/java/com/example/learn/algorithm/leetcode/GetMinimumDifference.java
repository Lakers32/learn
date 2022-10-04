package com.example.learn.algorithm.leetcode;

import java.util.Stack;

/**
 * @description: 二叉搜索树的最小绝对差
 * <p>
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * @author: 程凯
 * @create: 2022-10-03 20:53
 **/
public class GetMinimumDifference {

    /**
     * 记录上一个遍历的结点
     */
    TreeNode pre;
    int result = Integer.MAX_VALUE;

    /**
     * 不同节点的最小差值，就是相连两点的最小差值
     * 又是二叉搜索树，所以中序遍历。找相邻节点，所以双指针
     *
     * @param root
     * @return
     */
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        //左
        traversal(root.left);
        //中
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        //右
        traversal(root.right);
    }

    Stack<TreeNode> stack;
    public int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        stack = new Stack<>();
        TreeNode cur = root;
        int result = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 将访问的节点放进栈
                stack.push(cur);
                // 左
                cur = cur.left;
            }else {
                cur = stack.pop();
                // 中
                if (pre != null) {
                    result = Math.min(result, cur.val - pre.val);
                }
                pre = cur;
                // 右
                cur = cur.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(15);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        GetMinimumDifference getMinimumDifference = new GetMinimumDifference();
        System.out.println("Get Minimum Difference Is " + getMinimumDifference.solution(root));
    }
}
