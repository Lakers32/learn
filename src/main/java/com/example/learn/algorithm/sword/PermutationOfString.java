package com.example.learn.algorithm.sword;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 剑指 Offer 38. 字符串的排列
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。例如
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * @author: cheng kai
 * @create: 2021-02-23 20:10
 **/
public class PermutationOfString {

    List<String> permutationList = new LinkedList<>();
    char[] chars;

    public String[] solution(String s) {
        chars = s.toCharArray();
        dfs(0);
        return permutationList.toArray(new String[permutationList.size()]);
    }

    /**
     * 回溯法
     *
     * @param x
     */
    private void dfs(int x) {
        if (x == chars.length - 1) {
            // 添加排列方案
            permutationList.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            // 重复，因此剪枝
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            // 交换，将 c[i] 固定在第 x 位
            swap(i, x);
            // 开启固定第 x + 1 位字符
            dfs(x + 1);
            // 恢复交换(回溯)
            swap(i, x);
        }
    }

    private void swap(int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    public static void main(String[] args) {
        PermutationOfString algs = new PermutationOfString();
        String string = "abc";
        System.out.println("The permutation is " + algs.solution(string));
    }

}
