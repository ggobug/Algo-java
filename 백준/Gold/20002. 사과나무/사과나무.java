import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;   // 과수원 크기
    static int[][] garden;  // 과수원
    static int maxProfit = Integer.MIN_VALUE;   // 최대 이익

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        garden = new int[N][N]; // 과수원 초기화
        int[][] accum = new int[N + 1][N + 1];  // 누적합 배열 초기화

        // 과수원 배열 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                garden[i][j] = Integer.parseInt(st.nextToken());
                accum[i + 1][j + 1] = garden[i][j]
                        + accum[i][j + 1]
                        + accum[i + 1][j]
                        - accum[i][j];
            }
        }

        // 시작 좌표, 끝 좌표
        int[] startPoint = new int[2];
        int[] endPoint = new int[2];

        // 최대 이익 갱신하기
        for (int k = 1; k <= N; k++) { // K x K 크기
            for (int i = k; i <= N; i++) {
                for (int j = k; j <= N; j++) {
                    int subSum = accum[i][j]
                            - accum[i - k][j]
                            - accum[i][j - k]
                            + accum[i - k][j - k];
                    maxProfit = Math.max(maxProfit, subSum);
                }
            }
        }

        // 최대 이익 출력
        System.out.println(maxProfit);
    }
}
