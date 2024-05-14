package boj.pb_17845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 과목의 중요도 합의 최대값
// 배낭 문제

public class Main {

    static int N, K;    // 최대 공부 시간, 과목 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] importances = new int[K + 1];
        int[] costs = new int[K + 1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            importances[i] = Integer.parseInt(st.nextToken());   // 중요도
            costs[i] = Integer.parseInt(st.nextToken());   // 필요한 공부 시간
        }

        int[] dp = new int[N + 1];

        for (int i = 1; i <= K; i++) {
            int importance = importances[i];
            int cost = costs[i];
            for (int j = N; j >= 1; j--) {
                if (cost <= j) {
                    dp[j] = Math.max(dp[j], dp[j - cost] + importance);
                }
            }
        }
        System.out.println(dp[N]);
    }
}
