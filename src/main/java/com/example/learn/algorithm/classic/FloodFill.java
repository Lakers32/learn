package com.example.learn.algorithm.classic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 面试题 08.10. 颜色填充
 * <p>
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * <p>
 * 示例
 * 输入：
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2],[2,2,0],[2,0,1]]
 * 解释:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 * <p>
 * 链接：https://leetcode-cn.com/problems/color-fill-lcci
 * <p>
 * 链接：https://leetcode-cn.com/problems/color-fill-lcci
 * @author: cheng kai
 * @create: 2021-03-20 14:12
 **/
public class FloodFill {

    /**
     * 深度优先搜索（DFS）
     */
    public static int[][] solution(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor, image[sr][sc]);

        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }

        // 待修改值为老值，且不为新值
        if (image[sr][sc] == oldColor && image[sr][sc] != newColor) {
            image[sr][sc] = newColor;
            dfs(image, sr, sc + 1, newColor, oldColor);
            dfs(image, sr, sc - 1, newColor, oldColor);
            dfs(image, sr - 1, sc, newColor, oldColor);
            dfs(image, sr + 1, sc, newColor, oldColor);
        }
    }

    /**
     * 广度优先搜索（BFS）
     */
    public static int[][] solution2(int[][] image, int sr, int sc, int newColor) {
        // 队列
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        // 方向数组
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int i = arr[0];
            int j = arr[1];
            int oldColor = image[i][j];
            image[i][j] = newColor;
            for (int k = 0; k < dir.length; k++) {
                int r = dir[k][0] + i;
                int c = dir[k][1] + j;
                if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == oldColor && image[r][c] != newColor) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;

        System.out.println("The new image is " + solution(image, sr, sc, newColor));
        System.out.println("The new image is " + solution2(image, sr, sc, newColor));
    }
}
