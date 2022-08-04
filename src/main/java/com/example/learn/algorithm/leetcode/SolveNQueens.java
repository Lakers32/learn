package com.example.learn.algorithm.leetcode;

import java.util.*;

/**
 * @Description: 51. N皇后
 * <p>
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * https://leetcode-cn.com/problems/n-queens
 * @Author: kotchen
 * @Date: 2021/6/5 19:17
 * @Version: 1.0
 **/
public class SolveNQueens {

    /**
     * 回溯思想
     *  每个皇后必须位于不同行和不同列，因此将 N 个皇后放置在 N×N 的棋盘上，一定是每一行有且仅有一个皇后，每一列有且仅有一个皇后，且任何两个皇后都不能在同一条斜线上。
     *  基于上述发现，可以通过回溯的方式寻找可能的解。
     *
     * 减枝方法：
     *  按照行回溯，按照列遍历，所以列上去重。
     *  从左上到右下方向，同一条斜线上的每个位置满足行下标与列下标之差相等，所以按照该方向上相等值去重。
     *  从右上到左下方向，同一条斜线上的每个位置满足行下标与列下标之和相等，所以按照该方向上相等值去重。
     *
     */

    /**
     * 基于集合的回溯
     *
     * @param n
     * @return
     */
    public List<List<String>> solution(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // 存在皇后的列记录(按照行进行遍历)
        Set<Integer> columns = new HashSet<Integer>();
        // 存在皇后的从左上到右下斜线记录1
        Set<Integer> diagonals1 = new HashSet<Integer>();
        // 存在皇后的从右上到左下斜线记录2
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    /**
     * @param solutions
     * @param queens
     * @param n
     * @param row
     * @param columns
     * @param diagonals1
     * @param diagonals2
     */
    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        // 触发结束条件
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
            return;
        }

        // 按列遍历
        for (int i = 0; i < n; i++) {
            // 排除不合法选择
            if (columns.contains(i)) {
                continue;
            }
            int diagonal1 = row - i;
            if (diagonals1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = row + i;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }

            // 做选择
            queens[row] = i;
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);

            // 进入下一行决策
            backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);

            // 撤销选择
            queens[row] = -1;
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }

    }

    /**
     * 生成满足条件的棋盘
     *
     * @param queens
     * @param n
     * @return
     */
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    /**
     * 基于位运算的回溯
     *
     * @param n
     * @return
     */
    public List<List<String>> solution2(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> solutions = new ArrayList<List<String>>();
        solve(solutions, queens, n, 0, 0, 0, 0);
        return solutions;
    }

    /**
     * @param solutions
     * @param queens
     * @param n
     * @param row
     * @param columns
     * @param diagonals1
     * @param diagonals2
     */
    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        // 触发结束条件
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
            return;
        }

        // 排除不合法选择，做出合理选择
        int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));

        while (availablePositions != 0) {
            // 做选择
            int position = availablePositions & (-availablePositions);
            availablePositions = availablePositions & (availablePositions - 1);
            int column = Integer.bitCount(position - 1);
            queens[row] = column;

            // 进入下一行决策
            solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);

            // 撤销选择
            queens[row] = -1;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println("The n queens are " + solveNQueens.solution(n));
    }

}
