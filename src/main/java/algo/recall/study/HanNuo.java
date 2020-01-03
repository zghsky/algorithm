package algo.recall.study;

public class HanNuo {
    public static void main(String[] args) {
        move(20, 'A', 'B', 'C');
    }

    private static void move(int n, char a, char b, char c) {
        if (n == 1)
            System.out.println(a + "-->" + c);
        else{
            move(n - 1, a, c, b);
            System.out.println(a + "-->" + c);
            move(n - 1, b, a, c);
        }
    }
}
