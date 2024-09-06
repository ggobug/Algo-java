import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] costs = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] =  + costs[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
            }
        }

        // 마지막 최소비용 출력
        int result = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
        System.out.println(result);
    }
}
