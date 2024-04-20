package boj.boj_16507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R+1][C+1];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i + 1][j + 1] = Integer.parseInt(st.nextToken())
                        + arr[i][j + 1] + arr[i + 1][j] - arr[i][j];
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int tmp = (arr[r2][c2] - arr[r1 - 1][c2] - arr[r2][c1 - 1] + arr[r1 - 1][c1 - 1])
                    / ((r2 - r1 + 1) * (c2 - c1 + 1));

            sb.append(tmp);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
