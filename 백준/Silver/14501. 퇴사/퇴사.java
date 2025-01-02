import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2]; // N+1일째도 포함

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) {
                // 상담 불가능: 다음 날 최대 이익 가져오기
                dp[i] = dp[i + 1];
            } else {
                // 상담 가능: 상담하지 않거나 상담하고 수익 추가
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            }
        }

        System.out.println(dp[1]);
    }
}
