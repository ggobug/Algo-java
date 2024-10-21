// 라그랑주의 네 제곱수 정리
// https://www.acmicpc.net/problem/3933

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // 최소 몇개의 제곱 수가 필요한지 저장하는 배열
        int[] dp = new int[32769];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i * i <= 32768; i++) {
            int square = i * i;
            for (int j = square; j <= 32768; j++) {
                dp[j] = Math.min(dp[j], dp[j - square] + 1);
            }
        }
        
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            if (n == 0) break;
            int count = 0;

            for (int a = 0; a * a <= n; a++) {
                for (int b = a; a * a + b * b <= n; b++) {
                    for (int c = b; a * a + b * b + c * c <= n; c++) {
                        int dSquared = n - (a * a + b * b + c * c);
                        int d = (int) Math.sqrt(dSquared);
                        if (d >= c && d * d == dSquared) {
                            count++;
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }
}
