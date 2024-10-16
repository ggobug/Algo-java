// 점수따먹기
// https://www.acmicpc.net/problem/1749

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

        // 누적합 구하기
        int[][] accum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                accum[i][j] = matrices[i - 1][j - 1]
                        + accum[i-1][j]
                        + accum[i][j-1]
                        - accum[i-1][j-1];
            }
        }

        int maxSum = Integer.MIN_VALUE; // 최대 구간 합

        // 행을 기준으로 구간합 계산
        for (int i1 = 1; i1 <= N; i1++) {
            for (int i2 = i1; i2 <= N; i2++) {
                // 열에 대한 구간 합을 저장하는 배열
                int[] colSum = new int[M + 1];
                for (int j = 1; j <= M; j++) {
                    colSum[j] = accum[i2][j] - accum[i1 - 1][j] - accum[i2][j-1] + accum[i1-1][j-1];
                }

                // 슬라이딩 윈도우로 1차원 최대 구간 합을 구함
                int currentSum = 0;
                for (int j = 1; j <= M; j++) {
                    currentSum = Math.max(colSum[j], currentSum + colSum[j]);
                    maxSum = Math.max(maxSum, currentSum);
                }
            }
        }

        System.out.println(maxSum);
    }
}
