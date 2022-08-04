package com.example.learn.algorithm.classic;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description: 面试题 16.15. 珠玑妙算
 * <p>
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
 * 例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。
 * 打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 * <p>
 * 链接：https://leetcode-cn.com/problems/master-mind-lcci
 * @author: cheng kai
 * @create: 2021-03-22 11:06
 **/
public class MasterMind {

    public static int[] solution(String solution, String guess) {
        int fake = 0, real = 0;
        // 设置一个长26的数组map（目的是将RYGB对应到数组的index中）
        int[] map = new int[26];

        // for循环遍历solution和guess
        for (int i = 0; i < 4; i++) {
            char sol = solution.charAt(i), gue = guess.charAt(i);
            // 如果solution和guess对应元素相等，则直接real++
            if (sol == gue) {
                real++;
            }
            // 若不相等，判断map中sol元素是否小于0（代表之前存过guess的元素），存在则fake++，然后更新map[sol - 'A']++
            else {
                if (map[sol - 'A'] < 0) {
                    fake++;
                }
                map[sol - 'A']++;

                if (map[gue - 'A'] > 0) {
                    fake++;
                }
                map[gue - 'A']--;
            }
        }

        return new int[]{real, fake};
    }

    public static int[] solution2(String solution, String guess) {

        // 使用了HashMap，将solution的元素保存到map中（包含元素数量）
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : solution.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 然后判断map中是否有guess的元素，有则fake++，注意要更新元素数量
        int fake = 0, real = 0;
        for (char c : guess.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                fake++;
                map.put(c, map.get(c) - 1);
            }
        }

        // 在来个for循环判断一致的数据real，最后fake - real等于伪猜对
        for (int i = 0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                real++;
            }
        }

        return new int[]{real, fake - real};
    }

    public static void main(String[] args) {
        String solution = "RGBY", guess = "GGRR";
        System.out.println("The master mind is " + Arrays.toString(solution(solution, guess)));
    }

}
