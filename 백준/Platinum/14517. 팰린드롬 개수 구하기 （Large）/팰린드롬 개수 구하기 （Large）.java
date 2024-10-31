// 팰린드롬 개수 구하기 (Large)
// https://www.acmicpc.net/problem/14517

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int n = word.length();
        int MOD = 10007;
        
        // DP 배열 생성
        int[][] dp = new int[n][n];

        // 부분수열 길이가 1인 경우 팰린드롬 (자기 자신)
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // 부분수열 길이가 2 이상인 경우 계산
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                // 기본 점화식
                dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + MOD) % MOD;

                // 만약 양 끝 문자가 같다면 추가적으로 팰린드롬을 생성
                if (word.charAt(i) == word.charAt(j)) {
                    dp[i][j] = (dp[i][j] + 1 + dp[i + 1][j - 1]) % MOD;
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}
