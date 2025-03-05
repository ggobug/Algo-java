// 앱
// https://www.acmicpc.net/problem/7579

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] memory, cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memory = new int[N];
        cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) memory[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cost[i] = Integer.parseInt(st.nextToken());

        int maxCost = Arrays.stream(cost).sum();    // 비용의 최대값
        int[] dp = new int[maxCost + 1];    //  비용 i로 확보 가능한 최대 메모리

        for (int i = 0; i < N; i++) {
            for (int j = maxCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        // 최소 비용 찾기
        for (int j = 0; j <= maxCost; j++) {
            if (dp[j] >= M) {
                System.out.println(j);
                return;
            }
        }
    }
}