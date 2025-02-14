import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];
        long maxProfit = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            maxProfit = Math.max(maxProfit, dp[i]);

            int next = i + t;
            if (next <= N) {
                dp[next] = Math.max(dp[next], maxProfit + p);
            }
        }

        System.out.println(Math.max(maxProfit, dp[N]));
    }
}
