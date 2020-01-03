package algo.dynamic.test;

/**
 * 最长子序列
 */
public class LongestSub {
    public static void main(String[] args) {

        String str1 = "abcde";
        String str2 = "ace";
        int sub = longestSub(str1, str2);
        System.out.println(sub);
    }

    private static int longestSub(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length() + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < text2.length() + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
