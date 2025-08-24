import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());    // 포도주 잔의 개수
        int[] wines = new int[n];
        for (int i = 0; i < n; i++) {
            wines[i] = Integer.parseInt(br.readLine().trim());
        }

        if (n == 1) {
            System.out.println(wines[0]);
            return;
        }
        if (n == 2) {
            System.out.println(wines[0] + wines[1]);
            return;
        }

        // dp[i]: i번째 잔까지 고려했을 때의 최대 양
        int[] dp = new int[n];
        dp[0] = wines[0];
        dp[1] = wines[0] + wines[1];
        dp[2] = Math.max(dp[1], Math.max(wines[0] + wines[2], wines[1] + wines[2]));

        for (int i = 3; i < n; i++) {
            int a = dp[i - 1];                          // i 안 마심
            int b = dp[i - 2] + wines[i];               // i만 마심, i-1은 안 마심
            int c = dp[i - 3] + wines[i - 1] + wines[i]; // i-1, i 모두 마심
            dp[i] = Math.max(a, Math.max(b, c));
        }

        System.out.println(dp[n - 1]);
    }
}
