package algo.leetcode.test2;

import java.util.Scanner;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例 2:
 * 输入: "226"
 * 输出: 3 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Solution91 {
    public static void main(String[] args) {
        System.out.println(numDecodings(new Scanner(System.in).next()));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();

        int help = 1;
        int res = 0;
        if (s.charAt(len - 1) != '0') res = 1;

        for (int i = len - 2; i >= 0 ; i--) {
            if (s.charAt(i) == '0') {
                help = res;
                res = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                res += help;
                help = res - help;
            } else help = res;
        }
        return res;
    }
}
