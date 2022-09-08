package com.example.learn.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: N 叉树的最大深度
 * <p>
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N叉树输入按层序遍历序列化表示，每组子节点由空值分隔。
 * <p>
 * 链接：https://leetcode.cn/problems/maximum-depth-of-n-ary-tree
 * @author: 程凯
 * @create: 2022-09-08 23:45
 **/
public class MaxDepthN {

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public int solution(TreeNodeN root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        if (root.children != null) {
            for (TreeNodeN child : root.children) {
                depth = Math.max(depth, solution(child));
            }
        }

        //中节点
        return depth + 1;
    }

    /**
     * 迭代法，使用层序遍历
     */
    public int solution2(TreeNodeN root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNodeN> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            depth++;
            int len = que.size();
            while (len > 0) {
                TreeNodeN node = que.poll();
                for (int i = 0; i < node.children.size(); i++) {
                    if (node.children.get(i) != null) {
                        que.offer(node.children.get(i));
                    }
                }
                len--;
            }
        }

        return depth;
    }
}
