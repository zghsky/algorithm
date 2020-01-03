package algo.leetcode.test;

import java.util.*;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class Solution51 {
    public static void main(String[] args) {
        System.out.println(solveNQueens2(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0 || n == 1) return res;
        List<String> list = new ArrayList<>();
        char[] chars = {'.', '.','.', '.','.', '.','.', '.','.', '.','.', '.'};
        for (int i = 0; i < n; i++) {
            list.add(new String(chars, 0, n));
        }
        backtrack(res, list, n, 0);
        return res;
    }

    private static void backtrack(List<List<String>> res, List<String> strs, int n, int i) {
        if (i == n) {
            res.add(new ArrayList<>(strs));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (check(strs, i, j)) {
                String str = strs.get(i);
                char[] chars = str.toCharArray();
                chars[j] = 'Q';
                strs.remove(i);
                strs.add(i, String.valueOf(chars));
                backtrack(res, strs, n, i + 1);
                strs.remove(i);
                strs.add(i, str);
            }
        }
    }

    private static boolean check(List<String> strs, int i, int j) {
        String str_i = strs.get(i);
        for (char c : str_i.toCharArray()) {
            if (c == 'Q') return false;
        }

        for (String str : strs) {
            if (str.charAt(j) == 'Q') return false;
        }

        int p1 = i;
        int p2 = j;
        int tmp = i + j;
        int tmp2 = i - j;
        while (p2 >= 0 && p2 < strs.size() && p1 >= 0 && p1 < strs.size()) {
            while (p2 >= 0 && p2 < strs.size() && p1 >= 0 && p1 < strs.size()) {
                if (strs.get(p1).charAt(p2) == 'Q') return false;
                p2--;
                p1 = tmp - p2;
            }
            p1 = i;
            p2 = j;
            while (p2 >= 0 && p2 < strs.size() && p1 >= 0 && p1 < strs.size()) {
                if (strs.get(p1).charAt(p2) == 'Q') return false;
                p2++;
                p1 = tmp - p2;
            }
            p1 = i;
            p2 = j;
            while (p2 >= 0 && p2 < strs.size() && p1 >= 0 && p1 < strs.size()) {
                if (strs.get(p1).charAt(p2) == 'Q') return false;
                p2--;
                p1 = tmp2 + p2;
            }
            p1 = i;
            p2 = j;
            while (p2 >= 0 && p2 < strs.size() && p1 >= 0 && p1 < strs.size()) {
                if (strs.get(p1).charAt(p2) == 'Q') return false;
                p2++;
                p1 = tmp2 + p2;
            }
        }
        return true;
    }

    public static int solveNQueens2(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> z_diagonal = new HashSet<>();
        Set<Integer> f_diagonal = new HashSet<>();
        int[] res = new int[1];
        backtrack(0, n, res, new ArrayList<>(), col, z_diagonal, f_diagonal);
        return res[0];
    }

    private static void backtrack(int i, int n, int[] res, ArrayList<String> tmp, Set<Integer> col,
                                  Set<Integer> z_diagonal, Set<Integer> f_diagonal) {
        if (i == n) {
            res[0]++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!col.contains(j) && !z_diagonal.contains(i + j) && !f_diagonal.contains(i - j)) {
                col.add(j);
                z_diagonal.add(i + j);
                f_diagonal.add(i - j);
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[j] = 'Q';
                tmp.add(new String(chars));
                backtrack(i + 1, n, res, tmp, col, z_diagonal, f_diagonal);
                tmp.remove(tmp.size() - 1);
                col.remove(j);
                z_diagonal.remove(i + j);
                f_diagonal.remove(i - j);
            }
        }
    }
}
