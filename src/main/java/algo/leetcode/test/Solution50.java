package algo.leetcode.test;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 *
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */
public class Solution50 {
    public static void main(String[] args) {
        System.out.println(myPow(0.80000, -2147483648));
        System.out.println(Math.abs(-2147483648));
    }

    public static double myPow(double x, int n) {
        if (x == 0) {
            return n > 0 ? 0 : 1 / 0.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1.0;
        }
        if (n == Integer.MIN_VALUE) {
            return 1 / myPow(x * x, -(n / 2));
        }
        double tmp = myPow(x, Math.abs(n) / 2);
        if (n % 2 != 0) {
            tmp = tmp * tmp * x;
        } else {
            tmp = tmp * tmp;
        }
        return n > 0 ? tmp : 1 / tmp;
    }
}
