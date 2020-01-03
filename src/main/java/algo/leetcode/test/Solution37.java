package algo.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * [['5','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9']]
 *
 */
public class Solution37 {
    public static void main(String[] args) {

        char[][] board = {
                { '5', '3', '.', '.' , '7', '.', '.', '.', '.'},
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
        solveSudoku(board);
        System.out.println("----------------------");
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public static void solveSudoku(char[][] board) {

        if (board == null || board.length == 0) return;
        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') points.add(new int[] { i, j });
            }
        }
        backtrack(0, points, board);
    }

    private static boolean backtrack(int i, List<int[]> points, char[][] board) {
        if (i == points.size()) return true;
        for (char c = '1'; c <= '9'; c++) {
            if (check(points.get(i), c, board)) {
                board[points.get(i)[0]][points.get(i)[1]] = c;
                if (backtrack(i + 1, points, board)) return true;
                board[points.get(i)[0]][points.get(i)[1]] = '.';
            }
        }
        return false;
    }

    private static boolean check(int[] ints, char c, char[][] board) {
        int row_i = ints[0];
        int col_j = ints[1];
        for (int i = 0; i < 9; i++) {
            if (i != row_i && board[i][col_j] == c) return false;
            if (i != col_j && board[row_i][i] == c) return false;
        }

        for (int i = row_i / 3 * 3; i < row_i / 3 * 3 + 3; i++) {
            for (int j = col_j / 3 * 3; j < col_j / 3 * 3 + 3; j++) {
                if (i != row_i && j != col_j && board[i][j] == c) return false;
            }
        }
        return true;
    }
}
