import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int M = Integer.parseInt(parts[0]);
        int N = Integer.parseInt(parts[1]);

        // 1부터 N까지 소수 기억하기
        boolean[] primes = new boolean[N + 1];
        Arrays.fill(primes, true);
        primes[1] = false;

        // 소수 판별
        for (int i = 2; i <= N; i++) {
            if (primes[i]) {
                int j = i * 2;
                while (j <= N) {
                    primes[j] = false;
                    j += i;
                }
            }
        }

        // 소수 출력
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            // 소수면 출력
            if (primes[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
