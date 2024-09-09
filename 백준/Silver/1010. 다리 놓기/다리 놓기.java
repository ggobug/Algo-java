import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int N, M;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dp = new int[M + 1][N + 1];

            System.out.println(combination(M, N));
        }
    }

    static int combination(int n, int x) {
        if (dp[n][x] != 0) {
            return dp[n][x];
        }

        if (x == 0 || x == n) {
            return dp[n][x] = 1;
        }

        dp[n][x] = combination(n - 1, x) + combination(n - 1, x - 1);
        return dp[n][x];
    }
}
