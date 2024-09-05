import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);

        // N! (팩토리얼 계산)
        long[] fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        // (K! * (N-K)!)의 역원을 계산하기 위해 분할정복을 통한 거듭제곱 사용
        long denominator = (fact[K] * fact[N - K]) % MOD;
        long denominatorInverse = modInverse(denominator, MOD);

        // 이항 계수 계산
        long result = fact[N] * denominatorInverse % MOD;
        System.out.println(result);

    }

    // 분할정복을 이용한 거듭제곱 계산
    static long modInverse(long a, long p) {
        return power(a, p - 2, p);
    }

    // 분할정복을 이용한 거듭제곱 (a^b % p)
    static long power(long a, long b, long p) {
        long result = 1;
        a = a % p;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % p;
            }
            a = (a * a) % p;
            b >>= 1;
        }

        return result;
    }
}
