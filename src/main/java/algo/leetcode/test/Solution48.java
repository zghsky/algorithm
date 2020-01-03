package algo.leetcode.test;

import java.util.Arrays;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 示例 2:
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class Solution48 {
    public static void main(String[] args) {
        int[][] matrix = {
                    { 5, 1, 9,11},
                    { 2, 4, 8,10},
                    {13, 3, 6, 7},
                    {15,14,12,16}
        };
        rotate2(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        int[][] help = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                help[j][i] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = help[i][n - j];
            }
        }
    }

    public static void rotate2(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                swap(matrix, i, j, matrix.length - 1 - i, j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j, int i1, int j1) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i1][j1];
        matrix[i1][j1] = tmp;
    }
}