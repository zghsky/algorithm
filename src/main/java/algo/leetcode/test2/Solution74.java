package algo.leetcode.test2;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class Solution74 {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1,   3,  5,  7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 50 }
        };
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 13));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix[0].length - 1;
        int lo = 0;
        int hi = matrix.length - 1;
        int col = matrix.length - 1;
        while (lo <= hi) {
            col = lo + (hi - lo) / 2;
            if (matrix[col][n] == target) return true;
            else if (col > 0 && matrix[col][n] > target && matrix[col - 1][n] < target) break;
            else if (matrix[col][n] > target) hi = col - 1;
            else lo = col + 1;
        }
        lo = 0;
        hi = matrix[col].length - 1;
        int row = 0;
        while (lo <= hi) {
            row = lo + (hi - lo) / 2;
            if (matrix[col][row] == target) return true;
            else if (matrix[col][row] > target) hi = row - 1;
            else lo = row + 1;
        }
        return false;
    }
}
