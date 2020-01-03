package algo.leetcode.test;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Solution45 {
    public static void main(String[] args) {
        System.out.println(jump2(new int[] { 2, 3, 1, 1, 4 }));
    }

    // 动态规划 O(n^2)
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length) break;
                if (dp[i + j] > 0)
                    dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                else
                    dp[i + j] = dp[i] + 1;
            }
        }
        return dp[nums.length - 1];
    }

    // 动态规划 + 贪心
    public static int jump2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j > 0; j--) {
                if (i + j >= nums.length - 1) return dp[i] + 1;
                else if (dp[i + j] == 0) dp[i + j] = dp[i] + 1;
                else break;
            }
        }
        return 0;
    }
}
