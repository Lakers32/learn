package com.example.learn.algorithm.classic;

/**
 * @description: 面试题 01.06. 字符串压缩
 * <p>
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * @author: cheng kai
 * @create: 2021-03-09 17:21
 **/
public class CompressString {

    /**
     * 模拟：保留前面第一次出现的那个与当前比较
     * 也是双指针
     *
     * @param S
     * @return
     */
    public static String solution(String S) {
        // 空串处理
        if (S.length() == 0) {
            return S;
        }

        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); ++i) {
            // 若与上一个暂存值一样，则计数加1
            if (ch == S.charAt(i)) {
                cnt++;
            }
            // 否则，添加上一个字符和计数，并初始化本字符和计数
            else {
                ans.append(ch);
                ans.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        ans.append(ch);
        ans.append(cnt);

        return ans.length() >= S.length() ? S : ans.toString();
    }

    /**
     * 双指针
     *
     * @param S
     * @return
     */
    public static String solution2(String S) {
        int length = S.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < length) {
            int j = i;
            while (j < length && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            sb.append(S.charAt(i));
            sb.append(j - i);
            i = j;
        }

        return sb.length() >= S.length() ? S : sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "aabcccccaaa";
        System.out.println("Compress string [" + str1 + "] is " + solution(str1));

        String str2 = "abbccd";
        System.out.println("Compress string [" + str2 + "] is " + solution(str2));
    }
}
