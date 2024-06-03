package boj.pb_1958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // LCS (Longest Common Subsequence)
    // 문자열 3개의 LCS 구하기
    // 길이는 100 이하
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String aStr = br.readLine();
        String bStr = br.readLine();
        String cStr = br.readLine();

        int aLen = aStr.length();
        int bLen = bStr.length();
        int cLen = cStr.length();

        int[][][] dp = new int[aLen + 1][bLen + 1][cLen + 1];

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                for (int k = 1; k <= cLen; k++) {
                    char aChar = aStr.charAt(i - 1);
                    char bChar = bStr.charAt(j - 1);
                    char cChar = cStr.charAt(k - 1);

                    if ((aChar == bChar) && (bChar == cChar)) dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    else dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                }
            }
        }

        System.out.println(dp[aLen][bLen][cLen]);
    }
}
