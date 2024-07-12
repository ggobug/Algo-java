import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1000 이하 소수 찾기
        boolean[] primes = new boolean[1001];
        Arrays.fill(primes, true);
        primes[1] = false;

        for (int i = 2; i <= 1000; i++) {
            if (primes[i]) {
                int j = i * 2;
                while (j <= 1000) {
                    primes[j] = false;
                    j += i;
                }
            }
        }

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (primes[num]) answer++;
        }
        System.out.println(answer);
    }
}
