import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] factorial = new long[13];
        factorial[0] = 1L;
        for (int i = 1; i < 13; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        System.out.println(factorial[N]);
    }
}
