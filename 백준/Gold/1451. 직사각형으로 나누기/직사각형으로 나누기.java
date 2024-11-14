import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]); // 직사각형 가로 크기
        int M = Integer.parseInt(parts[1]); // 직사각형 세로 크기

        // 목표: 직사각형의 합의 곱의 최댓값 구하기
        long maxValue = Long.MIN_VALUE;
        long[][] squares = new long[N + 1][M + 1];

        // 직사각형 수 입력 받기, 누적합 배열로 전환
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                squares[i][j] = (input.charAt(j - 1) - '0') + squares[i - 1][j] + squares[i][j - 1] - squares[i - 1][j - 1];
            }
        }
//        System.out.println(Arrays.toString(squares[1]));

        // (i, j) 좌표 이동하면서 최댓값 갱신
        // (i, j) 좌표 기준 상 하 좌 우 로 3분할 하기
        // 1 <= i <= N - 1, 1 <= j <= M - 1
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= M - 1; j++) {
                // 해당 좌표 사분면을 만들어 네 개의 직사각형의 합 구하기
                long sumA = squares[i][j];                      // 북서
                long sumB = squares[i][M] - sumA;               // 북동
                long sumC = squares[N][j] - sumA;               // 남서
                long sumD = squares[N][M] - sumA - sumB - sumC; // 남동

                // 상 : 위가 큰 직사각형
                maxValue = Math.max(maxValue, (sumA + sumB) * sumC * sumD);

                // 하 : 아래가 큰 직사각형
                maxValue = Math.max(maxValue, sumA * sumB * (sumC + sumD));

                // 좌 : 왼쪽이 큰 직사각형
                maxValue = Math.max(maxValue, (sumA + sumC) * sumB * sumD);

                // 우 : 오른쪽이 큰 직사각형
                maxValue = Math.max(maxValue, (sumD + sumB) * sumA * sumC);
            }
        }

        // 한 방향으로 분할하기
        // 1. 가로 삼분할
        for (int i = 1; i <= M - 2; i++) {
            for (int j = i + 1; j <= M - 1; j++) {
                long sumA = squares[N][i];
                long sumB = squares[N][j] - sumA;
                long sumC = squares[N][M] - sumA - sumB;
                maxValue = Math.max(maxValue, sumA * sumB * sumC);
            }
        }

        // 2. 세로 삼분할
        for (int i = 1; i <= N - 2; i++) {
            for (int j = i + 1; j <= N - 1; j++) {
                long sumA = squares[i][M];
                long sumB = squares[j][M] - sumA;
                long sumC = squares[N][M] - sumA - sumB;
                maxValue = Math.max(maxValue, sumA * sumB * sumC);
            }
        }

        System.out.println(maxValue);
    }
}
