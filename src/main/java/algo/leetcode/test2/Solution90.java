package algo.leetcode.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {1, 2, 2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        backtrack(res, 0, nums, new ArrayList<>());
        return res;
    }

    public static void backtrack(List<List<Integer>> res, int i, int[] nums, List<Integer> tmp) {
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;
            tmp.add(nums[j]);
            res.add(new ArrayList<>(tmp));
            backtrack(res, j + 1, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
