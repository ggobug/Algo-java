import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 전체 수의 범위
        int M = Integer.parseInt(st.nextToken()); // 고를 수의 개수
        int K = Integer.parseInt(st.nextToken()); // 적어도 일치해야 하는 수의 개수

        // 복권에 당첨될 확률 계산
        double probability = calculateProbability(N, M, K);

        // 확률 출력
        bw.write(Double.toString(probability));
        bw.newLine();

        br.close();
        bw.close();
    }

    // 복권에 당첨될 확률을 계산하는 메서드
    public static double calculateProbability(int N, int M, int K) {
        // 전체 경우의 수
        int totalCases = combination(N, M);

        // 적어도 K개의 수가 같을 경우의 수
        int successfulCases = 0;

        for (int i = 0; i < M - K + 1; i++) {
            successfulCases += combination(M, K + i) * combination(N - M, M - K - i);
        }

        // 확률 계산
        double probability = (double) successfulCases / totalCases;

        return probability;
    }

    // 조합을 계산하는 메서드
    public static int combination(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }

        int a = 1;
        int b = 1;

        for (int i = 0; i < r; i++) {
            a *= (n - i);
            b *= (i + 1);
        }
        return a / b;
    }
}
