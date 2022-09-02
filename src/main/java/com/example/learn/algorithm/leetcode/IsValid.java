package com.example.learn.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 链接：https://leetcode.cn/problems/valid-parentheses
 */
public class IsValid {

    /**
     * 不满足分成三种情况
     * 1、多了左括号
     * 2、多了右括号
     * 3、括号不匹配
     *
     * @param s
     * @return
     */
    public boolean solution(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
            }
            // 多了右括号或者括号不匹配
            else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            } else {
                //如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }

        // 最后判断栈中元素是否匹配（多了左括号）
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        String s1 = "()";
        System.out.println("() is valid? " + isValid.solution(s1));

        String s2 = "()[]{}";
        System.out.println("()[]{} is valid ? " + isValid.solution(s2));

        String s3 = "(]";
        System.out.println("(] is valid ? " + isValid.solution(s3));

        String s4 = "([)]";
        System.out.println("([)] is valid ? " + isValid.solution(s4));
    }
}
