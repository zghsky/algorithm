package algo.leetcode.test;

public class Solution26 {
    public static void main(String[] args) {

        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 使用快慢指针删除重复元素
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length == 1)
            return 1;
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[fast - 1]) {
                fast++;
            } else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }
}
