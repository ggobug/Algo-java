package boj.boj_17123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] A;
    static int r1, c1, r2, c2, v;
    static int[] sumRows, sumCols;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        in();
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            in();
            N = getInteger();
            M = getInteger();

            // 배열 A
            A = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                in();
                for (int j = 1; j <= N; j++) {
                    A[i][j] = getInteger();
                }
            }

            sumRows = new int[N+1];
            sumCols = new int[N+1];
            for (int i = 0; i < M; i++) {
                in();
                r1 = getInteger();
                c1 = getInteger();
                r2 = getInteger();
                c2 = getInteger();
                v = getInteger();
                for (int j = r1; j <= r2; j++) {
                    sumRows[j] += (c2 - c1 + 1) * v;
                }
                for (int j = c1; j <= c2; j++) {
                    sumCols[j] += (r2 - r1 + 1) * v;
                }
            }

            sumRow(A);
            sumCol(A);
        }
        System.out.println(sb);

    }


    static void in() throws IOException {
        st = new StringTokenizer(br.readLine());
    }

    static int getInteger() {
        return Integer.parseInt(st.nextToken());
    }

    // 행 합
    static void sumRow(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            sb.append(Arrays.stream(arr[i]).sum() + sumRows[i]).append(" ");
        }
        sb.append("\n");
    }

    // 열 합
    static void sumCol(int[][] arr) {
        for (int j = 1; j < arr[0].length; j++) {
            int temp = 0;
            for (int i = 1; i < arr.length; i++) {
                temp += arr[i][j];
            }
            sb.append(temp + sumCols[j]).append(" ");
        }
        sb.append("\n");
    }

    static void printArray(int[][] arr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb2);
    }
}
