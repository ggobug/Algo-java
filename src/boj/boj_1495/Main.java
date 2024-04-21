package boj.boj_1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, S, M;
    static int[] volumes;
    static int max = Integer.MIN_VALUE;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 연주할 곡 수
        S = Integer.parseInt(st.nextToken()); // 시작 볼륨
        M = Integer.parseInt(st.nextToken()); // 볼륨 최대 크기

        volumes = new int[N];
        visited = new boolean[N][M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, S);
        if (max == Integer.MIN_VALUE) {
            max = -1;
        }
        System.out.println(max);
    }

    private static void dfs(int n, int curVolume) {

        // 마지막 곡이면
        if (n == N) {
            max = Math.max(max, curVolume);
            return;
        }

        if (visited[n][curVolume]) {
            return;
        }

        visited[n][curVolume] = true;

        if (curVolume + volumes[n] <= M) {
            dfs(n + 1, curVolume + volumes[n]);
        }

        if (curVolume - volumes[n] >= 0) {
            dfs(n + 1, curVolume - volumes[n]);
        }
    }
}
