package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 47. 礼物的最大价值
 * <p>
 * 在一个m*n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @author: cheng kai
 * @create: 2021-03-01 14:52
 **/
public class MaxPathSumOfArray {

    /**
     * 动态规划
     *
     * @param grid
     * @return
     */
    public static int solution(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }

        return grid[m - 1][n - 1];
    }

    /**
     * 动态规划
     *
     * @param grid
     * @return
     */
    public static int solution2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 初始化第一行
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        // 初始化第一列
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }

        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println("Max path sum is " + solution(grid));
    }
}
