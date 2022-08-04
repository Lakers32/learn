package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 04. 二维数组中的查找
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @author: cheng kai
 * @create: 2021-02-03 10:41
 **/
public class IsNumberIn2DArray {

    /**
     * 暴力遍历
     * <p>
     * 复杂度分析
     * 时间复杂度：O(nm)。二维数组中的每个元素都被遍历，因此时间复杂度为二维数组的大小。
     * 空间复杂度：O(1)。
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean solution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 类似将二维数据旋转90°，然后进行二分查找
     * 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。
     * 如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean solution2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println("Is target 5 in the matrix? " + solution2(matrix, 5));
        System.out.println("Is target 20 in the matrix? " + solution2(matrix, 20));
    }


}
