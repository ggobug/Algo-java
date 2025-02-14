import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];
        int[] terms = new int[N];
        int[] prices = new int[N];

        String[] input;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            terms[i] = Integer.parseInt(input[0]);
            prices[i] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < N; i++) {
            // i일까지의 최대 수익 유지
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            int next = i + terms[i];
            if (next <= N) {
                dp[next] = Math.max(dp[next], dp[i] + prices[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
