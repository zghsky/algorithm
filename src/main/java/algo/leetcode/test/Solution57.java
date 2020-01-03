package algo.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 *
 * 示例 2:
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Solution57 {
    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 2 },
                { 3, 5 },
                { 6, 7 },
                { 8, 10 },
                { 12, 16 }
        };
        int[] newInterval = { 4, 8 };
        int[][] res = insert(intervals, newInterval);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }

        System.out.println("-------------------");
        int[][] intervals2 = {
                { 1, 5 },
                { 4, 9 }
        };
        int[] newInterval2 = { 2, 3 };
        int[][] res2 = insert(intervals2, newInterval2);
        for (int[] re : res2) {
            System.out.println(Arrays.toString(re));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
