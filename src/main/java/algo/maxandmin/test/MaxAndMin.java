package algo.maxandmin.test;

import java.util.Arrays;

public class MaxAndMin {
    public static void main(String[] args) {

        int[] nums = { 5, 3, 7, 9, 1, 2, 4, 9 };
        System.out.println(Arrays.toString(max_and_min3(nums)));
        System.out.println(Arrays.toString(max1_and_max2(nums)));
    }

    private static int[] max_and_min(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return new int[] { min, max };
    }

    private static int[] max1_and_max2(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return new int[] { max1, max2 };
    }

    private static int[] max_and_min2(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i + 1]);
            } else {
                max = Math.max(max, nums[i + 1]);
                min = Math.min(min, nums[i]);
            }
        }
        return new int[] { min, max };
    }

    private static int[] max_and_min3(int[] nums) {
        return max_and_min_core(nums, 0, nums.length - 1);
    }

    private static int[] max_and_min_core(int[] nums, int lo, int hi) {
        if (hi - lo == 0 && lo >= 0 && hi < nums.length) {
            return new int[] { nums[hi], nums[hi] };
        }

        int mid = (lo + hi) / 2;
        int[] max_min1 = max_and_min_core(nums, lo, mid);
        int[] max_min2 = max_and_min_core(nums, mid + 1, hi);
        return new int[] { Math.min(max_min1[0], max_min2[0]),
                Math.max(max_min1[1], max_min2[1]) };
    }
}
