package algo.leetcode.test;

import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution56 {
    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 }
        };
        int[][] res = merge(intervals);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
        int[][] intervals2 = {
                { 1, 4 },
                { 0, 4 }
        };
        int[][] res2 = merge(intervals2);
        for (int[] ints : res2) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, (x, y)->{
            return x[0] - y[0];
        });
        int i = 1;
        int j = 0;
        while (i < intervals.length) {
            if (intervals[i][0] > intervals[j][1]) {
                j++;
                intervals[j][0] = intervals[i][0];
                intervals[j][1] = intervals[i][1];
            }
            else if (intervals[i][1] > intervals[j][1]){
                intervals[j][1] = intervals[i][1];
            }
            i++;
        }
        int[][] res = new int[j + 1][2];
        for (int k = 0; k < j + 1; k++) {
            res[k][0] = intervals[k][0];
            res[k][1] = intervals[k][1];
        }
        return res;
    }
}
