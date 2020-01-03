package algo.leetcode.test;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 */
public class Solution35 {
    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 6 };

        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));

        int[] nums2 = { 1, 3 };
        System.out.println(searchInsert(nums2, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int index = -1;
        if (nums == null || nums.length == 0) return index;
        if (nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            else if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        if (index == -1) {
            index = lo;
        }
        return index;
    }
}
