package boj.boj_20057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int ans = 0;
    static double[][] sp = {
            {2, 0, 0, 0.05}, // 앞으로 2칸
            {2, 0, 3, 0.1}, // 오른쪽 앞 대각선
            {2, 0, 1, 0.1}, // 왼쪽 앞 대각선
            {1, 1, 0.07},    // 왼쪽
            {1, 3, 0.07},    // 오른쪽
            {2, 1, 1, 0.02}, // 왼쪽 두칸
            {2, 3, 3, 0.02}, // 오른쪽 두칸
            {2, 2, 3, 0.01}, // 오른쪽 뒤 대각선
            {2, 2, 1, 0.01}  // 왼쪽 뒤 대각선
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tornado();
        System.out.println(ans);

    }

    // 토네이도
    private static void tornado() {
        int size = 1;
        int x = (N - 1) / 2;
        int y = (N - 1) / 2;
        int d = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < size; j++) {
                x += dx[d];
                y += dy[d];
                spread(x, y, d);
            }
            d = (d + 1) % 4;

            for (int j = 0; j < size; j++) {
                x += dx[d];
                y += dy[d];
                spread(x, y, d);
            }
            d = (d + 1) % 4;
            size += 1;
        }

        for (int j = 0; j < N - 1; j++) {
            x += dx[d];
            y += dy[d];
            spread(x, y, d);
        }
    }

    // 모래 이동
    private static void spread(int x, int y, int d) {

        // 토네이도 이동 후 위치의 모래 양
        int sand = arr[x][y];
        int newSand = sand;

        int nx;
        int ny;
        for (double[] ints : sp) {

            nx = x;
            ny = y;

            int nd;
            int index = 0;

            if (ints[0] == 1) {
                nd = (d + (int)ints[1]) % 4;
                nx += dx[nd];
                ny += dy[nd];
                index = 2;
            }

            if (ints[0] == 2) {
                nd = (d + (int)ints[1]) % 4;
                nx += dx[nd];
                ny += dy[nd];
                nd = (d + (int)ints[2]) % 4;
                nx += dx[nd];
                ny += dy[nd];
                index = 3;
            }

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                arr[nx][ny] += (int) (sand * ints[index]);
                newSand -= (int) (sand * ints[index]);
            } else {
                ans += (int) (sand * ints[index]);
                newSand -= (int) (sand * ints[index]);
            }
        }
        nx = x + dx[d];
        ny = y + dy[d];
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
            arr[nx][ny] += newSand;
        } else {
            ans += newSand;
        }
        arr[x][y] = 0;
    }

    private static void printArray(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
