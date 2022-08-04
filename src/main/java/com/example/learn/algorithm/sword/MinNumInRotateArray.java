package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 11. 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @author: cheng kai
 * @create: 2021-02-11 15:27
 **/
public class MinNumInRotateArray {

    public static int solution(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};

        System.out.println("min number is " + solution(numbers));
    }
}
