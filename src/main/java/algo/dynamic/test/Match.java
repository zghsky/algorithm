package algo.dynamic.test;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 */
public class Match {
    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        System.out.println(match(s, p));
    }

    public static boolean match(String s, String p) {

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        dp[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++) {
            if (p.charAt(i - 1) != '*') break;
            else dp[i][0] = true;
        }
        for (int i = 1; i < p.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                if (p.charAt(i - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
