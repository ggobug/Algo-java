import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        /*
        * f(1) = 1
        * f(2) = f(1) + 6 * 1
        * ...
        * f(n) = f(n-1) + 6 * (n-1)
        * f(n) = 3 * n * (n-1) + 1
        * */

        if (n == 1) {
            System.out.println(1);
            return;
        }

        long count = 1;
        long range = 2;

        while (range <= n) {
            range += 6 * count;
            count++;
        }
        System.out.println(count);
    }
}
