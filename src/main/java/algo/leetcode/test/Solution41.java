package algo.leetcode.test;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 说明:
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class Solution41 {
    public static void main(String[] args) {

        int[] nums = { 1, 2, 0 };
        int[] nums2 = { 1, -1, 3, 4 };
        int[] nums3 = { 7, 8, 9, 10, 11 };

        System.out.println(firstMissingPositive(nums));
        System.out.println(firstMissingPositive(nums2));
        System.out.println(firstMissingPositive(nums3));
    }
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] - 1 != i)
                swap(nums, i, nums[i] - 1);
        }
        int i = 0;
        while (i < nums.length && i == nums[i] - 1) i++;
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
