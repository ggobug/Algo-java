// https://www.acmicpc.net/problem/1563
// 개근상

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 한 학기 N일
        int MOD = 1_000_000;

        // 지각 두 번 이상 또는 결석 세 번 연속인 경우 : 개근상 못 받음

        // dp[i][j][k] : i번째 날까지, j번 지각, k번 연속 결석
        // N * 2 * 3 : O(N)
        int[][][] dp = new int[N + 1][2][3];

        // 첫날
        dp[1][0][0] = 1; // 첫날 출석
        dp[1][0][1] = 1; // 첫날 결석
        dp[1][1][0] = 1; // 첫날 지각

        for (int i = 2; i <= N; i++) {

            // 출석
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }

            // 지각 : 지각 횟수 없는 경우
            for (int k = 0; k < 3; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }

            // 결석 : 연속 결석 횟수가 1번 이하인 경우
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k + 1] = (dp[i][j][k + 1] + dp[i - 1][j][k]) % MOD;
                }
            }
        }

        // 개근상 받을 수 있는 출결정보 수
        int answer = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                answer = (answer + dp[N][j][k]) % MOD;
            }
        }

        System.out.println(answer);
    }
}
