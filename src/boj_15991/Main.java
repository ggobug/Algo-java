package boj_15991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int mod = 1_000_000_009;
        long[] dp = new long[100001];

        dp[0] = dp[1] = 1;
        dp[2] = dp[3] = 2;
        dp[4] = dp[5] = 3;

        for (int i = 6; i <= 100000; i++) {
            dp[i] = (dp[i - 6] + dp[i - 4] + dp[i - 2]) % mod;
        }

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
