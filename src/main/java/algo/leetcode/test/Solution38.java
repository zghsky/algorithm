package algo.leetcode.test;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 */
public class Solution38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        String res = "1";

        for (int i = 1; i < n; i++) {
            res = next_time(res);
        }
        return res;
    }

    private static String next_time(String res) {
        int i = 0;
        int n = res.length();
        StringBuffer ans = new StringBuffer();
        while (i < n) {
            int count = 1;
            while ((i < n - 1) && (res.charAt(i) == res.charAt(i + 1))) {
                i++;
                count++;
            }
            ans.append(count + "" + res.charAt(i));
            i++;
        }
        return ans.toString();
    }
}