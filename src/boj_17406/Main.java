package boj_17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N; // 행 크기
    static int M; // 열 크기
    static int K; // 회전 연산 횟수
    static int[][] arr;
    static List<int[]> order = new ArrayList<>();
    static List<List<int[]>> allList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1; // 중심 행
            int c = Integer.parseInt(st.nextToken()) - 1; // 중심 열
            int s = Integer.parseInt(st.nextToken()); // 크기
            int[] list = {r, c, s};
            order.add(list);
        }


    }

    // 순열
    static void permutation(int[] A, int depth, int a, int b) {
        if (depth == b) {
            List<int[]> temp = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                temp.add(order.get(i));
            }
            allList.add(temp);
            return;
        }
        for (int i = depth; i < a; i++) {
            swap(A, depth, i);
            order.set(depth, A);
            permutation(A, depth + 1, a, b);
            swap(A, depth, i);
        }
    }

    static void swap(int[] A, int depth, int i) {
        int temp = A[depth];
        A[depth] = A[i];
        A[i] = temp;
    }


    // 시계방향 회전
    static void rotate(int r, int c, int s) {
        int edge;
        while (s != 0) {

            // 윗쪽
            edge = arr[r - s][c + s];
            for (int j = c + s; j > c - s; j--) {
                arr[r - s][j] = arr[r - s][j - 1];
            }

            // 오른쪽
            int temp = edge;
            edge = arr[r + s][c + s];
            for (int i = r + s; i > r - s + 1; i--) {
                arr[i][c + s] = arr[i - 1][c + s];
            }
            arr[r - s + 1][c + s] = temp;

            // 아래쪽
            temp = edge;
            edge = arr[r + s][c - s];
            for (int j = c - s; j < c + s - 1; j++) {
                arr[r + s][j] = arr[r + s][j + 1];
            }
            arr[r + s][c + s - 1] = temp;

            // 왼쪽
            temp = edge;
            edge = arr[r - s][c - s];
            for (int i = r - s; i < r + s - 1; i++) {
                arr[i][c - s] = arr[i + 1][c - s];
            }
            arr[r + s - 1][c - s] = temp;

            s--;
        }
    }

    // 배열 행 합의 최솟값
    static int arrMin() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            min = Math.min(min, Arrays.stream(arr[i]).sum());
        }
        return min;
    }

    static void printArray() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
