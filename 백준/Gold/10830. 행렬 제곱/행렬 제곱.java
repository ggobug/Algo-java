import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long B;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = power(matrix, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    // 행렬 거듭제곱 (분할 정복)
    static int[][] power(int[][] A, long exp) {
        if (exp == 1) return A;

        if (exp % 2 == 0) {
            int[][] half = power(A, exp / 2);
            return multiply(half, half);
        } else {
            return multiply(power(A, exp - 1), A);
        }
    }

    // 행렬 곱셈 연산
    static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum = (sum + A[i][k] * B[k][j]) % 1000;
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}