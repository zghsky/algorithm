package algo.sort.test;

public class SleepSort {

    public static void sleepSort(int[] arr) {
        for (int num : arr) {
            new Thread(() ->{
                try {
                    Thread.sleep(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(num);
            }).start();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 30, 50, 60, 100, 40, 150, 200, 70};
        sleepSort(arr);
    }
}
