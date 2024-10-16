import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 행 크기
        int M = Integer.parseInt(st.nextToken());   // 열 크기

        // 행렬 배열 초기화
        int[][] matrices = new int[N][M];

        // 행렬 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrices[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = Integer.MIN_VALUE; // 최대 구간 합

        // 행을 기준으로 구간합 계산
        for (int i1 = 0; i1 < N; i1++) {
            int[] colSum = new int[M]; // 열에 대한 구간 합을 저장하는 배열

            for (int i2 = i1; i2 < N; i2++) {
                for (int j = 0; j < M; j++) {
                    colSum[j] += matrices[i2][j];
                }

                int currentSum = 0;
                for (int j = 0; j < M; j++) {
                    currentSum = Math.max(colSum[j], currentSum + colSum[j]);
                    maxSum = Math.max(maxSum, currentSum);
                }
            }
        }

        System.out.println(maxSum);
    }
}
