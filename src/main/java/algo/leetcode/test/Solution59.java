package algo.leetcode.test;

import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Solution59 {
    public static void main(String[] args) {
        int[][] res = generateMatrix(4);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) return res;
        int count = 1;
        int size = n * n;
        int i = 0;
        int j = 0;
        while (count <= size) {
            while (j < n && res[i][j] == 0) res[i][j++] = count++;
            j--;
            i++;
            while (i < n && res[i][j] == 0) res[i++][j] = count++;
            i--;
            j--;
            while (j >= 0 && res[i][j] == 0) res[i][j--] = count++;
            j++;
            i--;
            while (i >= 0 && res[i][j] == 0) res[i--][j] = count++;
            i++;
            j++;
        }
        return res;
    }
}
