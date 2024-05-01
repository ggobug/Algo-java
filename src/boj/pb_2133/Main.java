package boj.pb_2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 3x2 -> 3가지
        // 3x4 -> 2가지
        int[] dp = new int[31];
        dp[0] = 1;
        dp[2] = 3;
        dp[4] = 11;
        dp[6] = dp[0] * 2 + dp[4] * 3 + dp[2] * 2;
        for (int i = 7; i <= 30; i++) {
            dp[i] = dp[i - 2] * 3;
            for (int j = 4; j <= i; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
        }
        System.out.println(dp[N]);
    }
}
