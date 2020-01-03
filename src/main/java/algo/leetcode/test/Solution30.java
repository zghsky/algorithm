package algo.leetcode.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 */
public class Solution30 {
    public static void main(String[] args) {

        String s = "barfoothefoobarman";
        String[] words = { "foo","bar" };
        System.out.println(findSubstring2(s, words));

        s = "wordgoodgoodgoodbestword";
        String[] words2 = { "word","good","best","word" };
        System.out.println(findSubstring2(s, words2));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmp_map)) res.add(i);
        }
        return res;
    }

    // 滑动窗口 牛逼
    public static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int oneWord = words[0].length();
        int wordsLen = oneWord * words.length;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < oneWord; i++) {
            int left = i;
            int right = i;
            int count = 0;
            HashMap<String, Integer> tmpMap = new HashMap<>();
            while (right + oneWord <= s.length()) {
                String w = s.substring(right, right + oneWord);
                tmpMap.put(w, tmpMap.getOrDefault(w, 0) + 1);
                right += oneWord;
                count++;
                while (tmpMap.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                    String tmpW = s.substring(left, left + oneWord);
                    count--;
                    tmpMap.put(tmpW, tmpMap.getOrDefault(tmpW, 0) - 1);
                    left += oneWord;
                }
                if (count == words.length) res.add(left);
            }
        }
        return res;
    }
}
