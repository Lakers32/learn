package com.example.learn.algorithm.sword;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 剑指 Offer 37. 序列化二叉树或者反序列化
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你可以将以下二叉树：
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * <p>
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * @author: cheng kai
 * @create: 2021-02-23 17:28
 **/
public class SerializeBinaryTreeOrDeserialize {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Encodes a tree to a single string.
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder values = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                values.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                values.append("null,");
            }
        }
        values.deleteCharAt(values.length() - 1);
        values.append("]");

        return values.toString();
    }


    /**
     * Decodes your encoded data to tree.
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] values = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!values[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.left);
            }
            i++;
            if (!values[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        SerializeBinaryTreeOrDeserialize transfer = new SerializeBinaryTreeOrDeserialize();

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node3.right = node4;

        String serializeString = transfer.serialize(root);
        System.out.println("serialize node is " + serializeString);
        TreeNode deserializeNode = transfer.deserialize(serializeString);
        System.out.println();
    }
}
