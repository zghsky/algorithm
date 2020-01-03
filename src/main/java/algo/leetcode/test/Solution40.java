package algo.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */
public class Solution40 {
    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        System.out.println(combinationSum2(candidates, 8));
        int[] candidates2 = { 2, 5, 2, 1, 2 };
        System.out.println(combinationSum2(candidates2, 5));

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, 0, 0, new ArrayList<>());
        return res;
    }

    private static void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, int tmp_sum, List<Integer> tmp_list) {
        if (target == tmp_sum) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (tmp_sum + candidates[j] > target) break;
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            tmp_list.add(candidates[j]);
            backtrack(candidates, target, res, j + 1, tmp_sum + candidates[j], tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }
}
