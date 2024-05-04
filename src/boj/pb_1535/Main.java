package boj.pb_1535;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] costs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] happiness = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            happiness[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101];

        for (int i = 1; i <= n; i++) {
            for (int j = 99; j >= 0; j--) {
                int temp = costs[i] + j;
                if (temp < 100) {
                    dp[temp] = Math.max(dp[temp], dp[j] + happiness[i]);
                }
            }
        }
        System.out.println(dp[99]);






    }
}
