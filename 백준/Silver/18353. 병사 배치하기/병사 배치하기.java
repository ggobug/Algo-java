// https://www.acmicpc.net/problem/18353
// 병사 배치하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 병사의 수
        int[] powers = new int[N];

        // 전투력 입력 받기
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            powers[i] = Integer.parseInt(inputs[i]);
        }

        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            if (dp[i] == 0) {
                dp[i] = 1;

                for (int j = 0; j < i; j++) {
                    // 전투력 내림차순 && 길이가 갱신되면
                    if (powers[j] > powers[i] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        
        int maxLength = 0;  // 최장 길이
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println(N - maxLength);
    }
}
