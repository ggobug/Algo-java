import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 표의 크기
        int M = Integer.parseInt(st.nextToken());   // 합을 구하는 횟수

        // 표 입력 받기
        int[][] table = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 배열 생성
        int[][] accum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                accum[i][j] = accum[i][j - 1] + accum[i - 1][j] - accum[i - 1][j - 1] + table[i - 1][j - 1];
            }
        }

        // 합 계산 및 출력
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // (x1, y1)부터 (x2, y2)까지의 합 계산
            int sum = accum[x2][y2] - accum[x1 - 1][y2] - accum[x2][y1 - 1] + accum[x1 - 1][y1 - 1];
            sb.append(sum).append("\n");
        }
        System.out.print(sb);

    }
}
