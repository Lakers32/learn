package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 10.05. 稀疏数组搜索
 * <p>
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * https://leetcode-cn.com/problems/sparse-array-search-lcci/
 * @author: cheng kai
 * @create: 2021-03-20 16:37
 **/
public class FindStringIndexInSparseMatrix {

    public static int solution(String[] words, String s) {
        int left = 0, right = words.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 减少下标移动之后，还是可能出现mid为空的情况
            if (words[mid].equals("") && !words[left].equals(s)) {
                left++;
                continue;
            } else if (words[left].equals(s)) {
                return left;
            }

            // 正常二分查找
            if (words[mid].equals(s)) {
                return mid;
                //mid在s后面
            } else if (words[mid].compareTo(s) > 0) {
                right = mid;
                //mid在s前面
            } else if (words[mid].compareTo(s) < 0) {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static int solution2(String[] words, String s) {
        int left = 0, right = words.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 减少下标移动之后，还是可能出现mid为空的情况
            int tmp = mid;
            while (mid < right && words[mid].equals("")) {
                mid++;
            }
            if (mid == right) {
                right = tmp;
                continue;
            }

            // 正常二分查找
            if (words[mid].equals(s)) {
                return mid;
                //mid在s后面
            } else if (words[mid].compareTo(s) > 0) {
                right = mid;
                //mid在s前面
            } else if (words[mid].compareTo(s) < 0) {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};
        String s = "ta";
        System.out.println("The index of s in words is " + solution(words, s));

        String[] words2 = {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};
        String s2 = "ball";
        System.out.println("The index of s2 in words2 is " + solution(words2, s2));
    }
}
