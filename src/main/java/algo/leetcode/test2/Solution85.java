package algo.leetcode.test2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */
public class Solution85 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle2(matrix));
        System.out.println(maximalRectangle3(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int height[] = new int[matrix[0].length];
        int max_area = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') height[j] ++;
                else height[j] = 0;
            }
            max_area = Math.max(max_area, largestRectangleArea(height));
        }
        return max_area;
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max_area = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max_area = Math.max(max_area, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            max_area = Math.max(max_area, heights[stack.pop()] * (heights.length - stack.peek() -1 ));
        }
        return max_area;
    }

    public static int maximalRectangle2(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length + 1];
        int max_area = 0;
        for (int i = 0; i < matrix.length; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            heights[matrix[i].length] = 0;
            for (int j = 0; j <= matrix[i].length; j ++) {
                if (j < matrix[i].length) {
                    if (matrix[i][j] == '1') heights[j] ++;
                    else heights[j] = 0;
                }
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[j]) {
                    max_area = Math.max(max_area, heights[stack.pop()] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
        }
        return max_area;
    }

    public static int maximalRectangle3(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[] left_min = new int[matrix[0].length];
        int[] right_min = new int[matrix[0].length];
        Arrays.fill(left_min, -1);
        Arrays.fill(right_min, matrix[0].length);
        int[] heights = new int[matrix[0].length];
        int max_area = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }

            int boundary = -1;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') left_min[j] = Math.max(left_min[j], boundary);
                else {
                    left_min[j] = -1;
                    boundary = j;
                }
            }

            boundary = matrix[i].length;
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right_min[j] = Math.min(right_min[j], boundary);
                else {
                    right_min[j] = matrix[i].length;
                    boundary = j;
                }
            }

            for (int j = 0; j < matrix[i].length; j++) {
                max_area = Math.max(max_area, heights[j] * (right_min[j] - left_min[j] - 1));
            }
        }
        return max_area;
    }
}
