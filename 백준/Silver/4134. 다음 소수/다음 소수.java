import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double d = 4_000_000_000D;
        int size = (int) Math.sqrt(d);

        boolean[] primes = new boolean[size + 1];
        Arrays.fill(primes, true);
        primes[1] = false;

        // 소수 판별
        for (int i = 2; i <= size; i++) {
            if (primes[i]) {
                int j = i * 2;
                while (j <= size) {
                    primes[j] = false;
                    j += i;
                }
            }
        }


        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            long n = Long.parseLong(br.readLine());

            // n보다 크거나 같은 소수 중 가장 작은 소수

            if (n <= 1) {
                sb.append(2).append("\n");
                continue;
            }

            // n 이상의 첫 번째 소수를 찾는다
            while (true) {
                if (isPrime(n, primes)) {
                    sb.append(n).append("\n");
                    break;
                }
                n++;
            }
        }
        System.out.println(sb);
    }

    // 주어진 숫자가 소수인지 판별하는 함수
    private static boolean isPrime(long n, boolean[] primes) {
        if (n <= primes.length - 1) {
            return primes[(int) n]; // 미리 계산된 소수 배열을 이용하여 판별
        }

        // 제곱근까지 소수로 나누어 떨어지는지 확인
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i] && n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
