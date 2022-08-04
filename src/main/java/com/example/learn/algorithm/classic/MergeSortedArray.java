package com.example.learn.algorithm.classic;

import java.util.Arrays;

/**
 * @description:面试题 10.01. 合并排序的数组
 * <p>
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 * 编写一个方法，将 B 合并入 A 并排序。  初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * @author: cheng kai
 * @create: 2021-03-20 14:29
 **/
public class MergeSortedArray {

    /**
     * 直接合并后排序
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void solution(int[] A, int m, int[] B, int n) {
        for (int i = 0; i != n; ++i) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);
    }

    /**
     * 双指针
     * 方法一没有利用数组 A 与 B 已经被排序的性质。为了利用这一性质，我们可以使用双指针方法。
     * 这一方法将两个数组看作队列，每次从两个数组头部取出比较小的数字放到结果中
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void solution2(int[] A, int m, int[] B, int n) {
        int pa = 0, pb = 0;
        int[] sorted = new int[m + n];
        int cur;

        while (pa < m || pb < n) {
            // 数组A已经越界，添加B
            if (pa == m) {
                cur = B[pb++];
            }
            // 数组B已经越界，添加A
            else if (pb == n) {
                cur = A[pa++];
            }
            // A < B，添加A
            else if (A[pa] < B[pb]) {
                cur = A[pa++];
            }
            // A >= B，添加B
            else {
                cur = B[pb++];
            }
            sorted[pa + pb - 1] = cur;
        }

        /**
         * 将排序后的数组添加到A
         */
        for (int i = 0; i != m + n; ++i) {
            A[i] = sorted[i];
        }
    }

    /**
     * 逆向双指针
     * 方法二中，之所以要使用临时变量，是因为如果直接合并到数组 A 中，A 中的元素可能会在取出之前被覆盖。
     * 那么如何直接避免覆盖 A 中的元素呢？
     * 观察可知，A 的后半部分是空的，可以直接覆盖而不会影响结果。因此可以指针设置为从后向前遍历，每次取两者之中的较大者放进 A 的最后面。
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void solution3(int[] A, int m, int[] B, int n) {
        int pa = m - 1, pb = n - 1;
        int tail = m + n - 1;
        int cur;

        while (pa >= 0 || pb >= 0) {
            // A已经到头，当前值为B
            if (pa == -1) {
                cur = B[pb--];
            }
            // B已经到头，当前值为A
            else if (pb == -1) {
                cur = A[pa--];
            }
            // A大于B，当前值为A
            else if (A[pa] > B[pb]) {
                cur = A[pa--];
            }
            // B大于A，当前值为B
            else {
                cur = B[pb--];
            }
            A[tail--] = cur;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 0, 0, 0}, B = {3, 5, 6};
        int m = 3, n = 3;

/*        solution2(A, m, B, n);
        System.out.println("The merged array is " + Arrays.toString(A));*/

        solution3(A, m, B, n);
        System.out.println("The merged array is " + Arrays.toString(A));
    }

}
