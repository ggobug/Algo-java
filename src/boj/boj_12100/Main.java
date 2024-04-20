package boj.boj_12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(ans);
    }

    // 왼쪽으로
    static int[][] moveLeft(int[][] arr) {

        int[][] newArr = new int[N][N];

        for (int i = 0; i < N; i++) {

            Deque<Integer> tmp = new ArrayDeque<>();
            boolean isMerged = false;

            for (int j = 0; j < N; j++) {

                if (arr[i][j] == 0) {
                    continue;
                }

                if (tmp.isEmpty()) {
                    tmp.push(arr[i][j]);
                } else {
                    if (tmp.peekLast() == arr[i][j] && !isMerged) {
                        tmp.pollLast();
                        tmp.add(arr[i][j] * 2);
                        isMerged = true;
                    } else {
                        tmp.add(arr[i][j]);
                        isMerged = false;
                    }
                }
            }
            int size = tmp.size();
            for (int j = 0; j < size; j++) {
                newArr[i][j] = tmp.pollFirst();
            }
        }

        return newArr;
    }

    // 오른쪽으로
    static int[][] moveRight(int[][] arr) {

        int[][] newArr = new int[N][N];

        for (int i = 0; i < N; i++) {

            Deque<Integer> tmp = new ArrayDeque<>();
            boolean isMerged = false;

            for (int j = N - 1; j >= 0; j--) {

                if (arr[i][j] == 0) {
                    continue;
                }

                if (tmp.isEmpty()) {
                    tmp.push(arr[i][j]);
                } else {
                    if (tmp.peekLast() == arr[i][j] && !isMerged) {
                        tmp.pollLast();
                        tmp.add(arr[i][j] * 2);
                        isMerged = true;
                    } else {
                        tmp.add(arr[i][j]);
                        isMerged = false;
                    }
                }
            }
            int size = tmp.size();
            for (int j = N - 1; j > N - 1 - size; j--) {
                newArr[i][j] = tmp.poll();
            }
        }

        return newArr;
    }

    // 위쪽으로
    static int[][] moveUp(int[][] arr) {

        int[][] newArr = new int[N][N];

        for (int j = 0; j < N; j++) {

            Deque<Integer> tmp = new ArrayDeque<>();
            boolean isMerged = false;

            for (int i = 0; i < N; i++) {

                if (arr[i][j] == 0) {
                    continue;
                }

                if (tmp.isEmpty()) {
                    tmp.push(arr[i][j]);
                } else {
                    if (tmp.peekLast() == arr[i][j] && !isMerged) {
                        tmp.pollLast();
                        tmp.add(arr[i][j] * 2);
                        isMerged = true;
                    } else {
                        tmp.add(arr[i][j]);
                        isMerged = false;
                    }
                }
            }
            int size = tmp.size();
            for (int i = 0; i < size; i++) {
                newArr[i][j] = tmp.poll();
            }
        }

        return newArr;
    }

    // 아래쪽으로
    static int[][] moveDown(int[][] arr) {

        int[][] newArr = new int[N][N];

        for (int j = 0; j < N; j++) {

            Deque<Integer> tmp = new ArrayDeque<>();
            boolean isMerged = false;

            for (int i = N - 1; i >= 0; i--) {

                if (arr[i][j] == 0) {
                    continue;
                }

                if (tmp.isEmpty()) {
                    tmp.push(arr[i][j]);
                } else {
                    if (tmp.peekLast() == arr[i][j] && !isMerged) {
                        tmp.pollLast();
                        tmp.add(arr[i][j] * 2);
                        isMerged = true;
                    } else {
                        tmp.add(arr[i][j]);
                        isMerged = false;
                    }
                }
            }
            int size = tmp.size();
            for (int i = N - 1; i > N - 1 - size; i--) {
                newArr[i][j] = tmp.poll();
            }
        }

        return newArr;

    }

    // bfs
    static void dfs(int x, int[][] arr) {

        if (x == 5) {
            ans = Math.max(findMax(arr), ans);
            return;
        }

        dfs(x + 1, moveLeft(arr));
        dfs(x + 1, moveRight(arr));
        dfs(x + 1, moveUp(arr));
        dfs(x + 1, moveDown(arr));

    }

    // 배열 출력
    static void printArray(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 배열의 최댓값 찾기
    static int findMax(int[][] arr) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }
        return max;
    }
}
