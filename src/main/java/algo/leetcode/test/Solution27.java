package algo.leetcode.test;

public class Solution27 {
    public static void main(String[] args) {

        int[] nums = { 3, 2, 2, 3 };
        int[] nums2 = { 0, 1, 2, 2, 3, 0, 4, 2 };

        System.out.println(removeElement(nums, 3));
        System.out.println(removeElement(nums2, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] == val) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }
}
