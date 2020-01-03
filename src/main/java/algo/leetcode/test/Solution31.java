package algo.leetcode.test;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */
public class Solution31 {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 3, 2, 1 };
        int[] nums3 = { 1, 1, 5 };

        nextPermutation(nums1);
        nextPermutation(nums2);
        nextPermutation(nums3);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }

    /**
     * 1、先找出最大索引 k 满足nums[k] < nums[k - 1], 如果不存在, 就反转整个数组
     * 2、在找出另一个索引nums[l] > nums[k]
     * 3、交换nums[l]和nums[k]
     * 4、最后反转nums[k + 1:]
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int k = -1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int l = -1;
        for (int i = nums.length - 1; i > 0 ; i--) {
            if (nums[i] > nums[k]) {
                l = i;
                break;
            }
        }
        swap(nums, k, l);
        reverse(nums, k + 1, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
