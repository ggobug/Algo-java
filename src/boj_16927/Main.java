package boj_16927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int R;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // R번 회전
        rotate(arr, R);

        printArray(arr);
    }

    public static void rotate(int[][] array, int count) {
        int sx = 0;
        int sy = 0;
        int ex = N - 1;
        int ey = M - 1;

        // 반시계 방향으로 회전
        while (sx < ex && sy < ey) {
            int rotationCount = count % ((ex - sx + 1) * 2 + (ey - sy + 1) * 2 - 4);    // 둘레로 나눈 나머지
            for (int r = 0; r < rotationCount; r++) {
                int temp = array[sx][sy];
                // 위쪽 변 이동
                for (int i = sy; i < ey; i++) {
                    array[sx][i] = array[sx][i + 1];
                }
                // 오른쪽 변 이동
                for (int i = sx; i < ex; i++) {
                    array[i][ey] = array[i + 1][ey];
                }
                // 아래쪽 변 이동
                for (int i = ey; i > sy; i--) {
                    array[ex][i] = array[ex][i - 1];
                }
                // 왼쪽 변 이동
                for (int i = ex; i > sx; i--) {
                    array[i][sy] = array[i - 1][sy];
                }
                array[sx + 1][sy] = temp;
            }
            sx++;
            sy++;
            ex--;
            ey--;
        }
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
