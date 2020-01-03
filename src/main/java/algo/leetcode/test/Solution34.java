package algo.leetcode.test;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */
public class Solution34 {
    public static void main(String[] args) {
        int[] nums1 = { 5, 7, 7, 8, 8, 10 };
        System.out.println(Arrays.toString(searchRange(nums1, 8)));
        System.out.println(Arrays.toString(searchRange(nums1, 6)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        if (nums == null || nums.length == 0) return res;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                int i = mid, j = mid;
                while (i >= 0 && nums[i] == target)
                    i--;
                while (j < nums.length && nums[j] == target)
                    j++;
                res[0] = i + 1;
                res[1] = j - 1;
                break;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
}
