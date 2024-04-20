package boj.boj_17276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = (int) (Integer.parseInt(st.nextToken()) / 45 + 8) % 8;

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int a = 0; a < d; a++) {
                arr = rotate(arr, n);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(arr[i][j]).append(" ");
                }sb.append("\n");
            }
        }System.out.println(sb);
    }

    // 배열 돌리기
    static int[][] rotate(int[][] arr, int n) {
        int mid = (n-1) / 2;
        int[][] nArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    nArr[i][mid] = arr[i][j];
                } else if (j == mid) {
                    nArr[i][n-1-i] = arr[i][j];
                } else if (i + j == n-1) {
                    nArr[mid][j] = arr[i][j];
                } else if (i == mid) {
                    nArr[j][j] = arr[i][j];
                } else {
                    nArr[i][j] = arr[i][j];
                }
            }
        }
        return nArr;
    }
}
