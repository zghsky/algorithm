package algo.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Solution54 {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9,10,11,12 },
                { 13,14,15,16 }
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        int i = 0;
        int j = 0;
        int count = matrix.length * matrix[0].length;
        while (count-- > 0) {
            while (j < matrix[0].length && !flag[i][j]) {
                res.add(matrix[i][j]);
                flag[i][j++] = true;
            }
            j--;
            i++;
            while (i < matrix.length && !flag[i][j]) {
                res.add(matrix[i][j]);
                flag[i++][j] = true;
            }
            i--;
            j--;
            while (j >= 0 && !flag[i][j]) {
                res.add(matrix[i][j]);
                flag[i][j--] = true;
            }
            j++;
            i--;
            while (i > 0 && !flag[i][j]) {
                res.add(matrix[i][j]);
                flag[i--][j] = true;
            }
            j++;
            i++;
        }
        return res;
    }
}
