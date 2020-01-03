package algo.leetcode.test2;

import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2:
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 进阶:
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class Solution73 {
    public static void main(String[] args) {
        int[][] matrix = {
                { 0,1,2,0 }, { 3,4,5,2 }, { 1,3,1,5 }
        };

        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        boolean[] col = new boolean[matrix.length];
        boolean[] row = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    col[i] = true;
                    row[j] = true;
                }
            }
        }

        for (int i = 0; i < col.length; i++) {
            if (col[i]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
