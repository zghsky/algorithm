package algo.leetcode.test;

public class Solution28 {
    public static void main(String[] args) {

        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
        System.out.println(haystack.indexOf(needle));

        haystack = "a";
        needle = "";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * KMP算法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals(""))
            return 0;
        int[] next = getNext(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1)
                    return i - j;
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return -1;
    }

    private static int[] getNext(String needle) {
        int[] next = new int[needle.length() + 1];
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < needle.length()) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
