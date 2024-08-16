import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if (n <= 2) {
            System.out.println(0);
        } else {
            System.out.println(n*(n-1)*(n-2)/6);
        }
        System.out.println(3);
    }
}
