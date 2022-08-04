package com.example.learn.algorithm.classic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 面试题 04.01. 节点间通路
 * <p>
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * <p>
 * https://leetcode-cn.com/problems/route-between-nodes-lcci/
 * @author: cheng kai
 * @create: 2021-03-17 08:34
 **/
public class FindWhetherExistsPathInDirectedGraph {

    /**
     * 邻接表 + 广度遍历
     * 有向图的计算机表示为邻接表和邻接矩阵
     *
     * @param n 所有节点个数
     * @param graph 图，n行2列的稀疏矩阵表示，
     * @param start 开始节点
     * @param target 目标节点(终止节点)
     * @return
     */
    public static boolean solution(int n, int[][] graph, int start, int target) {
        // edges 用来存储边的集合
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        int len = graph.length;
        Set<String> nodeConcatSet = new HashSet<>();
        // 遍历稀疏矩阵，把边的头到尾存在edges里，并去掉重复路线
        for (int j = 0; j < len; j++) {
            int from = graph[j][0];
            int to = graph[j][1];
            String nodeConcat = "from" + from + "to" + to;
            if (!nodeConcatSet.contains(nodeConcat)) {
                edges.get(from).add(to);
                nodeConcatSet.add(nodeConcat);
            }
        }

        return dfs(edges, start, target);
    }

    /**
     * 广度遍历
     *
     * @param edges
     * @param start
     * @param target
     * @return
     */
    public static boolean dfs(List<List<Integer>> edges, int start, int target) {
        // list为start为开始的边
        List<Integer> list = edges.get(start);

        // 如果target已经在list列表里，说明可以直接到达，直接返回true
        if (list.contains(target)) {
            return true;
        }
        // 如果找不到就在list这个候选列表里继续以当前候选节点为头开始找
        else {
            for (int cur : list) {
                // 如果说找到了，就直接返回true
                if (dfs(edges, cur, target)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] graph = {
                {0, 1},
                {0, 2},
                {1, 2},
                {1, 2}
        };
        int start = 0;
        int target = 2;

        System.out.println("Whether exists path in directed graph? " + solution(n, graph, start, target));
    }
}
