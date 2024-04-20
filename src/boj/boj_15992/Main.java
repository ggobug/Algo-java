package boj.boj_15992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int mod = 1_000_000_009;
        int[][] dp = new int[1001][1001];
        dp[0][0] = 1;

        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = 1; k < 4; k++) {
                    if (i < k) {
                        break;
                    }
                    dp[i][j] = (dp[i][j] + dp[i - k][j - 1]) % mod;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(dp[n][m]);
        }

    }
}