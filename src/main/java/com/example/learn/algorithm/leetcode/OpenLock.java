package com.example.learn.algorithm.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description: 752. 打开转盘锁
 * <p>
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * <p>
 * https://leetcode-cn.com/problems/open-the-lock/
 * @Author: kotchen
 * @Date: 2021/6/7 11:28
 * @Version: 1.0
 **/
public class OpenLock {

    /**
     * 将 s[j] 向上拨动⼀次
     *
     * @param s
     * @param j
     * @return
     */
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }

        return new String(ch);
    }

    /**
     * 将 s[i] 向下拨动⼀次
     *
     * @param s
     * @param j
     * @return
     */
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }

        return new String(ch);
    }

    /**
     * BFS框架，4个相互独立的BFS，下一层都是当前层的所有组合的四个位置值前后翻转组合
     *
     * @param deadends
     * @param target
     * @return
     */
    public int solution(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        // 可以不需要dead这个哈希集合，直接将这些元素初始化到visited集合中，效果是⼀样的，可能更加优雅⼀些。
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (deads.contains(cur)) {
                    continue;
                }

                if (cur.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    /**
     * 双向BFS
     *
     * @param deadends
     * @param target
     * @return
     */
    int solution2(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        // ⽤集合不⽤队列，可以快速判断元素是否存在
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int step = 0;
        set1.add("0000");
        set2.add(target);

        while (!set1.isEmpty() && !set2.isEmpty()) {
            // 哈希集合在遍历的过程中不能修改， ⽤temp存储扩散结果
            Set<String> temp = new HashSet<>();
            for (String cur : set1) {
                if (deads.contains(cur)) {
                    continue;
                }

                if (set2.contains(cur)) {
                    return step;
                }

                visited.add(cur);
                /* 将⼀个节点的未遍历相邻节点加⼊集合 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            step++;

            // temp相当于set1
            // 这⾥交换set1、set2， 下⼀轮while就是扩散set2
            set1 = set2;
            set2 = temp;
        }

        return -1;
    }


    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

        OpenLock openLock = new OpenLock();
        System.out.println("The min setp is " + openLock.solution(deadends, target));
    }

}
