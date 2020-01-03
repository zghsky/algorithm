package algo.leetcode.test2;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Solution67 {
    public static void main(String[] args) {
        System.out.println(addBinary("1", "11"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("1", "111"));
        System.out.println(addBinary("110010", "10111"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int tmp1 = (i >= 0 ? a.charAt(i--) - '0' : 0);
            int tmp2 = (j >= 0 ? b.charAt(j--) - '0' : 0);
            res.append((tmp1 + tmp2 + carry) % 2);
            carry = (tmp1 + tmp2 + carry) / 2;
        }
        return res.reverse().toString();
    }
}
