package com.example.learn.algorithm.sword;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 29. 顺时针打印矩阵
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/
 * @author: cheng kai
 * @create: 2021-02-22 10:22
 **/
public class PrintArrayBySpiralOrder {

    /**
     * 模拟法：构建以及运用方向二维数组directions精妙，但晦涩难懂
     *
     * @param matrix
     * @return
     */
    public static int[] solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    /**
     * 按层模拟
     *
     * @param matrix
     * @return
     */
    public static int[] solution2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            // 向右移动
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            // 向下移动
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                // 向左移动
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                // 向上移动
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Print array by spiral order is " + Arrays.toString(solution2(matrix)));
    }
}
