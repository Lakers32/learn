package com.example.learn.algorithm.sword;

import java.util.*;

/**
 * @description: 剑指 Offer 40. 最小的k个数（top K问题）
 * <p>
 * 输入整数数组arr，找出其中最小的k个数。例如，输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * <p>
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @author: cheng kai
 * @create: 2021-02-24 22:11
 **/
public class LeastKNumbers {

    /**
     * 排序后取出前k个数
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] solution(int[] arr, int k) {
        int[] vec = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    /**
     * 最大堆：当父节点的键值总是大于或等于任何一个子节点的键值。
     * 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
     * 1. 若目前堆的大小 小于K，将当前数字放入堆中。
     * 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
     * 反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] solution2(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) {
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            // 最大堆的首个值最大
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }

    /**
     * 快排
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] solution3(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param lo
     * @param hi
     * @param k
     * @return
     */
    private static int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    /**
     * 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
     *
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        // j位置的数值大于lo位置，故交换
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    /**
     * 交换数组中的下标值
     *
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 二叉搜索树
     * 与前两种方法相比，BST 有一个好处是求得的前K大的数字是有序的
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] solution4(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // TreeMap的key是数字, value是该数字的个数。
        // cnt表示当前map总共存了多少个数字。
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num : arr) {
            // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
            //    若当前数字比map中最大的数字还大，就直接忽略；
            //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                // put之后，lastEntry的值已经改变，该值为刚刚put的值
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }

        }

        // 最后返回map中的元素
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }

    /**
     * 数据范围有限时直接计数排序
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] solution5(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数(num是索引)
        int[] counter = new int[10001];
        for (int num : arr) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                // num是数值
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        System.out.println("Least K nums are" + Arrays.toString(solution5(arr, k)));
    }
}
