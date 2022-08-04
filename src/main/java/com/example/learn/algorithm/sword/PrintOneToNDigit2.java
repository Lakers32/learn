package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 17. 打印从1到最大的n位数
 * <p>
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出 1、2、3一直到最大的3位数999。
 * <p>
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @author: cheng kai
 * @create: 2021-02-20 09:47
 **/
public class PrintOneToNDigit2 {

    StringBuilder res;
    int n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String solution(int n) {
        this.n = n;
        // 数字字符串集
        res = new StringBuilder();
        // 定义长度为 n 的字符列表
        num = new char[n];
        // 开启全排列递归
        dfs(0);
        // 删除最后多余的逗号
        res.deleteCharAt(res.length() - 1);
        // 转化为字符串并返回
        return res.toString();
    }

    /**
     * DFS: Depth First Search深度优先搜索
     * 基于分治算法的思想，先固定高位，向低位递归，当个位已被固定时，添加数字的字符串。
     *
     * @param x 位置
     */
    private void dfs(int x) {
        // 终止条件：已固定完所有位
        if (x == n) {
            // 拼接num并添加至res尾部，使用逗号隔开
            res.append(String.valueOf(num) + ",");
            return;
        }
        // 遍历 ‘0‘ - ’9‘
        for (char i : loop) {
            // 固定第x位为i
            num[x] = i;
            // 开启固定第x+1位
            dfs(x + 1);
        }
    }

    public static void main(String[] args) {
        PrintOneToNDigit2 print = new PrintOneToNDigit2();
        System.out.println("1位数的所有数字为" + print.solution(1));
        System.out.println("2位数的所有数字为" + print.solution(2));
    }
}
