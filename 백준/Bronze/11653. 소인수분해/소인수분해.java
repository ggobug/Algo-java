import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        int divisor = 2;
        while (N != 1) {
            while (N % divisor == 0) {
                sb.append(divisor).append("\n");
                N /= divisor;
            }
            divisor++;
        }
        System.out.println(sb);
    }
}
