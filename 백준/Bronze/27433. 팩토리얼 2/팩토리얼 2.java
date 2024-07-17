import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] factorial = new long[21];
        factorial[0] = 1L;
        for (int i = 1; i <= 20; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        int N = Integer.parseInt(br.readLine());
        System.out.println(factorial[N]);
    }
}
