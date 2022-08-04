package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 01.08. 零矩阵
 * <p>
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * https://leetcode-cn.com/problems/zero-matrix-lcci/
 * @author: cheng kai
 * @create: 2021-03-09 19:56
 **/
public class SetZeroesInMatrix {

    /**
     * 两次遍历
     * 开辟空间，记录0所在行列
     *
     * @param matrix
     */
    public static void solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m], columns = new int[n];

        // 第一次遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }

        // 第二次遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 1 || columns[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 两次遍历
     * 先记录首行和首列，不用开辟空间
     *
     * @param matrix
     */
    public static void solution2(int[][] matrix) {
        boolean isFirstRowHaveZero = false;
        boolean isFirstColHaveZero = false;

        // 1.1 记录首列
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isFirstColHaveZero = true;
                break;
            }
        }

        // 1.2 记录首行
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowHaveZero = true;
                break;
            }
        }

        // 2、标记首行首列中的0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 3、利用2中的结果标记除首行首列剩下的0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 4.1、完善首列
        for (int i = 0; i < matrix.length; i++) {
            if (isFirstColHaveZero) {
                matrix[i][0] = 0;
            }
        }

        // 4.2、完善首行
        for (int j = 0; j < matrix[0].length; j++) {
            if (isFirstRowHaveZero) {
                matrix[0][j] = 0;
            }
        }

    }

    public static void main(String[] args) {
/*        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution2(matrix);*/

        int[][] matrix2 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        solution2(matrix2);
        System.out.println("");
    }
}
