import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 물품의 수
        int k = Integer.parseInt(st.nextToken());   // 버틸 수 있는 무게

        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken()); // 무게
            values[i] = Integer.parseInt(st.nextToken());  // 가치
        }

        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = k; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        System.out.println(dp[k]);
    }
}
