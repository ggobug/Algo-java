import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dp;
    static int callCnt1, callCnt2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        callCnt1 = 0; callCnt2 = 0;

        fibo(N);
        fibonacci(N);

        StringBuilder sb = new StringBuilder();
        sb.append(callCnt1).append(" ").append(callCnt2);
        System.out.println(sb);
    }

    private static int fibo(int x) {
        if (x == 1 || x == 2) {
            callCnt1++;
            return 1;
        }
        return fibo(x - 1) + fibo(x - 2);
    }

    private static int fibonacci(int x) {
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= x; i++) {
            callCnt2++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[x];
    }
}
