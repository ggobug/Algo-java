package boj.boj_17271;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 싸움 시간
        int M = Integer.parseInt(st.nextToken()); // B 스킬의 시전 시간
        int mod = 1_000_000_007;

        int[] dp = new int[100001];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1];
            if (i >= M) {
                dp[i] += dp[i - M];
            }
            dp[i] %= mod;
        }
        System.out.println(dp[N]);
    }
}
