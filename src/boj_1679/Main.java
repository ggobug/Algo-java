package boj_1679;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 게임에서 사용하는 정수의 수
        int[] usableNum = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            usableNum[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 최대 사용 횟수
        int size = usableNum[N-1] * K + 2;

        int[] dp = new int[size];
        Arrays.fill(dp, MAX_VALUE);
        for (int i = 0; i < size; i++) {
            if (Arrays.binarySearch(usableNum, i) >= 0) {
                dp[i] = 1;
            }
        }

        for (int i = 1; i < size; i++) {

            if (dp[i] == 1) {
                continue;
            }

            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }

            if (dp[i] > K) {
                if (i % 2 == 0) {
                    System.out.println("holsoon win at " + i);
                } else {
                    System.out.println("jjaksoon win at " + i);
                }
                return;
            }

        }
    }
}
