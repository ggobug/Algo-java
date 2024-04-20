package boj.boj_12026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        // 1번 ~ N번
        // k칸 점프 : k * k 에너지 소모

        int[] dp = new int[N];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);

        dp[0] = 0;

        Map<Character, Character> BOJ = new HashMap<>();
        BOJ.put('B', 'J');
        BOJ.put('O', 'B');
        BOJ.put('J', 'O');

        for (int i = 1; i < N; i++) {
            char pre = BOJ.get(str.charAt(i));
            for (int j = 0; j < i; j++) {
                if (pre == str.charAt(j) && dp[j] != max) {
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                }
            }
        }
        if (dp[N - 1] == max) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }
    }
}
