package algo.window.test;

public class SimpleLeapWindow {
    public static void main(String[] args) {
        System.out.println(calc(new int[] { 1, 2, 3, 4 }, 2));
        System.out.println(calc(new int[] { -1, 4, 7, -3, 8, 5, -2, 6 }, 3));
    }

    public static int calc(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length && i < k; i++) {
            sum += arr[i];
            if (sum > max)
                max = sum;
        }

        for (int i = k; i < arr.length; i++) {
            sum = sum - arr[i - k] + arr[i];
            if (sum > max)
                max = sum;
        }
        return max;
    }
}
