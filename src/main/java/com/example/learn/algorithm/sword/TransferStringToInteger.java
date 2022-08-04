package com.example.learn.algorithm.sword;

/**
 * @description: 剑指 Offer 67. 把字符串转换成整数
 * <p>
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−2 31,2 31− 1]。如果数值超过这个范围，请返回INT_MAX (2 31− 1) 或INT_MIN (−2 31) 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: cheng kai
 * @create: 2021-03-06 16:58
 **/
public class TransferStringToInteger {

    public static int solution(String str) {
        int intVal = 0, boundary = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();

        if (length == 0) {
            return 0;
        }

        // 首部空格： 删除之即可
        while (str.charAt(i) == ' ') {
            if (++i == length) {
                return 0;
            }
        }
        // 符号位： 三种情况，即 ''++'' , ''-−'' , ''无符号" ；新建一个变量保存符号位，返回前判断正负即可
        if (str.charAt(i) == '-') {
            sign = -1;
        }
        // 仅第一个符号位有效
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            i++;
        }
        // 正式遍历字符
        for (int j = i; j < length; j++) {
            // 非数字字符： 遇到首个非数字的字符时，应立即返回
            if (str.charAt(j) < '0' || str.charAt(j) > '9') {
                break;
            }
            // 执行拼接10×res≥2147483650越界 或者 拼接后是2147483648或2147483649越界
            if (intVal > boundary || intVal == boundary && str.charAt(j) > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 字符转数字： “此数字的 ASCII 码” 与 “ 0 的 ASCII 码” 相减即可
            intVal = intVal * 10 + (str.charAt(j) - '0');
        }

        // 添加符号并返回
        return sign * intVal;
    }

    public static void main(String[] args) {
        String str = "4193 with words";
        System.out.println("The integer in the string is " + solution(str));
    }
}
