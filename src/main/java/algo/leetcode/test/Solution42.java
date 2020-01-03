package algo.leetcode.test;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution42 {
    public static void main(String[] args) {

        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap2(height));
    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        for (int i = height.length - 2; i >= 0 ; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    public static int trap2(int[] height) {
        if ((height == null || height.length == 0)) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int res = 0;

        while (left < right) {
            if (height[left] < height[right]){
                if (height[left] > left_max) left_max = height[left];
                else {
                    res += left_max - height[left];
                    left++;
                }
            } else {
                if (height[right] > right_max) right_max = height[right];
                else {
                    res += right_max - height[right];
                    right--;
                }
            }
        }
        return res;
    }
}
