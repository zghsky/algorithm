package algo.leetcode.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 *
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 *
 * 示例 2:
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 *      给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 *      因此，当 n = 0 时，其格雷编码序列为 [0]。
 */
public class Solution89 {
    public static void main(String[] args) {
        System.out.println(grayCode(0));
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if (n == 0) return list;
        int count = 0;
        while (count < n) {
            int p = (int) Math.pow(2, count);
            for (int i = list.size() - 1; i >= 0 ; i--) {
                list.add(list.get(i) + p);
            }
            count++;
        }
        return list;
    }
}
