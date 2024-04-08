package boj_15993;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int mod = 1000000009;

        int T = Integer.parseInt(br.readLine());
        int size = 100001;
        int[][] dp = new int[size][2];
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 2;
        for (int j = 4; j < size; j++) {
            dp[j][0] = ((dp[j - 3][1] + dp[j - 2][1]) % mod + dp[j - 1][1]) % mod;
            dp[j][1] = ((dp[j - 3][0] + dp[j - 2][0]) % mod + dp[j - 1][0]) % mod;
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]+ " " + dp[N][1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
