import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        // 10000 이하 소수 찾기
        boolean[] primes = new boolean[10_001];
        Arrays.fill(primes, true);

        primes[1] = false; primes[0] = false;
        for (int i = 2; i <= 10_000; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= 10_000; j += i) {
                    primes[j] = false;
                }
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int minPrime = 0;
        for (int i = M; i <= N; i++) {
            if (primes[i]) {
                if (sum == 0) minPrime = i;
                sum += i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(minPrime);
    }
}
