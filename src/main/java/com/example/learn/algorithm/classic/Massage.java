package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 17.16. 按摩师
 * <p>
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * <p>
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * @author: cheng kai
 * @create: 2021-03-22 17:21
 **/
public class Massage {

    /**
     * 设计二维状态变量
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        // dp[i][0]：区间 [0, i] 里接受预约请求，并且下标为 i 的这一天不接受预约的最大时长
        // dp[i][1]：区间 [0, i] 里接受预约请求，并且下标为 i 的这一天接受预约的最大时长
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    /**
     * 设计一维状态变量
     *
     * @param nums
     * @return
     */
    public static int solution2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        // dp[i]：区间 [0, i] 里接受预约请求的最大时长
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            // 今天在选与不选中，选择一个最优的
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    /**
     * 根据方法一：状态数组多设置一行，以避免对极端用例进行讨论。
     *
     * @param nums
     * @return
     */
    public static int solution3(int[] nums) {
        int len = nums.length;

        // dp 数组多设置一行，相应地定义就要改变，遍历的一些细节也要相应改变
        // dp[i][0]：区间 [0, i) 里接受预约请求，并且下标为 i 的这一天不接受预约的最大时长
        // dp[i][1]：区间 [0, i) 里接受预约请求，并且下标为 i 的这一天接受预约的最大时长
        int[][] dp = new int[len + 1][2];

        // 注意：外层循环从 1 到 =len，相对 dp 数组而言，引用到 nums 数组的时候就要 -1
        for (int i = 1; i <= len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[len][0], dp[len][1]);
    }

    /**
     * 根据方法一，使用「滚动数组」技巧，将空间优化到常数级别
     *
     * @param nums
     * @return
     */
    public static int solution4(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        // dp[i & 1][0]：区间 [0, i] 里接受预约请求，并且下标为 i 的这一天不接受预约的最大时长
        // dp[i & 1][1]：区间 [0, i] 里接受预约请求，并且下标为 i 的这一天接受预约的最大时长
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i & 1][0] = Math.max(dp[(i - 1) & 1][0], dp[(i - 1) & 1][1]);
            dp[i & 1][1] = dp[(i - 1) & 1][0] + nums[i];
        }
        return Math.max(dp[(len - 1) & 1][0], dp[(len - 1) & 1][1]);
    }

    /**
     * 根据方法二，使用 3 个变量滚动完成计算，将空间优化到常数级别。
     *
     * @param nums
     * @return
     */
    public static int solution5(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        // dp[i % 3]：区间 [0，i] 里接受预约请求的最大时长
        int[] dp = new int[3];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            // 今天在选与不选中，选择一个最优的
            dp[i % 3] = Math.max(dp[(i - 1) % 3], dp[(i - 2) % 3] + nums[i]);
        }
        return dp[(len - 1) % 3];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("The max sum is " + solution(nums));
    }
}