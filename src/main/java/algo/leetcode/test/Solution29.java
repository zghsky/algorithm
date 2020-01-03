package algo.leetcode.test;

public class Solution29 {
    public static void main(String[] args) {

        int dividend = 10;
        int divisor = 3;
        System.out.println(divide(dividend, divisor));
        System.out.println(divide(7, -3));
    }

    public static int divide(int dividend, int divisor) {

        int sign = (dividend ^ divisor) >> 31;
        // abs 方法：获取绝对值
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        long res = 0;
        while (lDividend >= lDivisor) {
            long tmp = lDivisor;
            long i = 1;
            while (lDividend >= tmp) {
                lDividend -= tmp;
                res += i;
                i <<= 1;
                tmp <<= 1;
            }
        }
        if (sign == -1) res *= -1;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }
}
