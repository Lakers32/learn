package com.example.learn.algorithm.interview;

/**
 * 甲虫爬方格
 * <p>
 * 一只甲虫沿着方格线从A爬到B，每次只能向上或者向右爬一格，但是图中黑点不能通过。请问这只甲虫可以选择多少种不同的路线？
 */
public class BeetleCrawl {

    public void solution(int[][] nums, int left, int up) {
        // 初始化
        for (int i = 0; i < nums[nums.length - 1].length; i++) {
            nums[nums.length - 1][i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = 1;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[0].length - 1; j++) {
                if (i == up && j == left) {
                    nums[up][left] = 0;
                } else {
                    nums[i][j] = nums[i][j - 1] + nums[i + 1][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        BeetleCrawl beetleCrawl = new BeetleCrawl();
        int[][] nums = new int[5][6];
        int left = 2, up = 3;

        beetleCrawl.solution(nums, left, up);
        System.out.println("The end is " + nums[0][5]);
    }
}
