package algo.leetcode.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 * 示例:
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * 示例 2:
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 *
 * 示例 3:
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class Solution68 {
    public static void main(String[] args) {
        String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
        String[] words2 = { "What","must","be","acknowledgment","shall","be" };
        String[] words3 = { "Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do" };

        System.out.println(fullJustify(words, 16));
        System.out.println(fullJustify(words2, 16));
        System.out.println(fullJustify(words3, 20));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = words.length;

        while (i < n) {
            int left = i;
            int cur_row_len = words[i].length();
            i++;

            while (i < n) {
                if (cur_row_len + words[i].length() + 1 > maxWidth) break;
                cur_row_len += words[i].length() + 1;
                i++;
            }

            StringBuilder tmp = new StringBuilder();

            if (i == n) {
                for (int j = left; j < i; j++) {
                    tmp.append(words[j] + " ");
                }
                tmp.deleteCharAt(tmp.length() - 1);
                for (int j = tmp.length(); j < maxWidth; j++) {
                    tmp.append(" ");
                }
                res.add(tmp.toString());
                break;
            }

            int all_word_len = 0;
            for (int j = left; j < i; j++) {
                all_word_len += words[j].length();
            }

            int space_num = i - left - 1;
            int remain_space = maxWidth - all_word_len;
            int a = 0;
            int b = 0;
            if (space_num != 0) {
                a = remain_space / space_num;
                b = remain_space % space_num;
            }
            for (int j = left; j < i; j++) {
                if (tmp.length() > 0) {
                    for (int k = 0; k < a; k++) tmp.append(" ");
                    if (b != 0) {
                        tmp.append(" ");
                        b--;
                    }
                }
                tmp.append(words[j]);
            }
            for (int j = tmp.length(); j < maxWidth; j++) {
                tmp.append(" ");
            }
            res.add(tmp.toString());
        }
        return res;
    }
}
