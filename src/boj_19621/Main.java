package boj_19621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 19621번 회의실 배정 2
// https://www.acmicpc.net/problem/19621
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[n] = c;
        }

        dp[0] = arr[0];
        if (N >= 2) {
            dp[1] = Math.max(arr[0], arr[1]);
            for (int i = 2; i < N; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
            }
            System.out.println(dp[N-1]);
        } else {
            System.out.println(dp[0]);
        }

    }
}
