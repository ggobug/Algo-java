package boj.pb_1660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1660
// 캡틴 이다솜

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // n -> n(n+1)/2 -> (n^3 + 3n^2 + 2n) / 6
        // map은 순서를 보장하지 않는다.
        int[] sum = new int[122];

        for (int i = 1; i < 122; i++) {
            sum[i] = operation(i);
        }

        // dp 배열 초기화
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // dp 배열 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; sum[j] <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - sum[j]] + 1);
            }
        }

        System.out.println(dp[N]);
    }

    static int operation(int n) {
        return (n * n * n + 3 * n * n + 2 * n) / 6;
    }
}
