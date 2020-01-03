package algo.leetcode.test;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Solution49 {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams2(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 || strs == null) return new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String newStr = String.valueOf(tmp);
            if (!map.containsKey(newStr)) map.put(newStr, new ArrayList<>());
            map.get(newStr).add(str);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * ["cab","tin","pew","duh","may","ill","buy","bar","max","doc"]
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0 || strs == null) return new ArrayList<>();

        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int key = 1;
            for (char c : str.toCharArray()) {
                key *= prime[c - 'a'];
            }
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
