package com.example.learn.algorithm.sword;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 剑指 Offer 13. 机器人的运动范围
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @author: cheng kai
 * @create: 2021-02-11 21:48
 **/
public class MovingBoundaryOfRobot {

    /**
     * 广度优先搜索 breadth first search BFS  + 减枝
     * 我们将行坐标和列坐标数位之和大于k的格子看作障碍物，那么这道题就是一道很传统的搜索题目，
     * 我们可以使用广度优先搜索或者深度优先搜索来解决它，这里选择使用广度优先搜索的方法来讲解。
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int solution(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        // 初始化能够到达的格子数
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    /**
     * 深度优先搜索 Depth-first search DFS  + 减枝
     * 我们将行坐标和列坐标数位之和大于k的格子看作障碍物，那么这道题就是一道很传统的搜索题目，
     * 我们可以使用广度优先搜索或者深度优先搜索来解决它，这里选择使用深度优先搜索的方法来讲解。
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int solution2(int m, int n, int k) {
        return 0;
    }

    /**
     * 递推
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int solution3(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        // 初始化起点
        vis[0][0] = true;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 && j == 0)
                        || get(i) + get(j) > k) {
                    continue;
                }
                // 边界判断
                if (i - 1 >= 0) {
                    vis[i][j] |= vis[i - 1][j];
                }
                if (j - 1 >= 0) {
                    vis[i][j] |= vis[i][j - 1];
                }
                ans += vis[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    /**
     * 获取组成数字的单个数字和
     *
     * @param x
     * @return
     */
    private static int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int m = 2, n = 3, k = 1;

        System.out.println(solution3(m, n, k));
    }

}
