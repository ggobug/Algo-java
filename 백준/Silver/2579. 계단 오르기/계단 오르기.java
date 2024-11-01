import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 예외 처리: 계단이 한 개 또는 두 개인 경우
        if (n == 1) {
            bw.write(score[0] + "\n");
            bw.flush();
            return;
        }
        if (n == 2) {
            bw.write((score[0] + score[1]) + "\n");
            bw.flush();
            return;
        }

        // dp 배열 생성 및 초기값 설정
        int[] dp = new int[n];
        dp[0] = score[0];
        dp[1] = score[0] + score[1];
        dp[2] = Math.max(score[0] + score[2], score[1] + score[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }

        bw.write(dp[n - 1] + "\n");
        bw.flush();
    }
}
