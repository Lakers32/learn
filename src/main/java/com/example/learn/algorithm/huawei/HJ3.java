package com.example.learn.algorithm.huawei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，输入的数字大小满足 1 \le val \le 500 \1≤val≤500
 */
public class HJ3 {

    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        while (str.hasNextInt()) {
            int cn = str.nextInt();
            TreeSet<Integer> ts = new TreeSet<Integer>();
            while (cn > 0 && str.hasNextInt()) {
                ts.add(str.nextInt());
            }
            Iterator<Integer> it = ts.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }
}
