package algo.recall.study;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        char[] per = { 'A', 'B', 'C', 'D' };
        System.out.println(permutations(per));
    }

    public static List<List<Character>> permutations(char[] per) {
        List<List<Character>> res = new ArrayList<>();
        backtrack(res, per, new ArrayList<>());
        return res;
    }

    private static void backtrack(List<List<Character>> res, char[] per, List<Character> num) {
        if (num.size() == per.length) {
            res.add(new ArrayList<>(num));
            return;
        }

        for (int i = 0; i < per.length; i++) {
            if (num.contains(per[i]))
                continue;
            num.add(per[i]);
            backtrack(res, per, num);
            num.remove(num.size() - 1);
        }
    }
}
