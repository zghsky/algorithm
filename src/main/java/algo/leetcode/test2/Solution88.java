package algo.leetcode.test2;

import java.util.Arrays;

public class Solution88 {

    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m - 1, l = n - 1, i;
        for (i = m + n - 1; i >= 0 && l >= 0 && k >= 0; i--) {
            if (nums1[k] >= nums2[l]) nums1[i] = nums1[k--];
            else nums1[i] = nums2[l--];
        }
        while (l >= 0) nums1[i--] = nums2[l--];
        System.out.println(Arrays.toString(nums1));
    }
}
