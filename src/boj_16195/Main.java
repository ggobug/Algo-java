package boj_16195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        int mod = 1_000_000_009;

        int[][] dp = new int[1001][1001];
        dp[1][1] = 1;
        dp[2][1] = 1; dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 2; dp[3][3] = 1;

        for (int i = 4; i < 1001; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = ((dp[i - 1][j - 1] + dp[i - 2][j - 1]) % mod + dp[i - 3][j - 1]) % mod;
            }
        }

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int ans = 0;
            for (int i = 0; i <= m; i++) {
                ans += dp[n][i];
                ans %= mod;
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
