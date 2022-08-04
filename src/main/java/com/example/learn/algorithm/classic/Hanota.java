package com.example.learn.algorithm.classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 面试题 08.06. 汉诺塔问题
 * <p>
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。
 * 一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * 你需要原地修改栈。
 * <p>
 * 链接：https://leetcode-cn.com/problems/hanota-lcci
 * @author: cheng kai
 * @create: 2021-03-19 20:44
 **/
public class Hanota {

    /**
     * 将 A 上的所有盘子，借助 B，移动到C 上
     *
     * @param A 原柱子
     * @param B 辅助柱子
     * @param C 目标柱子
     */
    public static void solution(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlate(A.size(), A, B, C);
    }

    private static void movePlate(int num, List<Integer> original, List<Integer> auxiliary, List<Integer> target) {
        // 只剩一个盘子时，直接移动即可
        if (num == 1) {
            target.add(original.remove(original.size() - 1));
            return;
        }

        // 将 size-1 个盘子，从 original 移动到 auxiliary
        movePlate(num - 1, original, target, auxiliary);
        // 将 第size个盘子，从 original 移动到 target
        target.add(original.remove(original.size() - 1));
        // 将 size-1 个盘子，从 auxiliary 移动到 target
        movePlate(num - 1, auxiliary, original, target);
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();

        solution(A, B ,C);
        System.out.println("The final answer is " + C.toString());
    }
}
