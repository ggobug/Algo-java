import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] matrix = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j]: i번째 행렬부터 j번째 행렬까지 곱하는 데 필요한 최소 곱셈 연산 횟수
        int[][] dp = new int[N][N];

        // 행렬을 곱하는 순서를 최적화하기 위해 구간 길이를 점차 늘려가며 계산
        for (int length = 1; length < N; length++) { // 구간의 길이
            for (int i = 0; i + length < N; i++) {
                int j = i + length;
                dp[i][j] = Integer.MAX_VALUE;

                // i번째부터 j번째 행렬까지의 곱셈을 k번째에서 끊어 두 부분으로 나눔
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}
