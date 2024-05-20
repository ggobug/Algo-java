package boj.pb_16194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] pack = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pack[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.min(dp[i], pack[i]);
            for (int j = 1; j < i; j++) {
                if (dp[i - j] < Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
                }
            }
        }
        System.out.println(dp[N]);


    }
}
