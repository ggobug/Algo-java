// 내리막길
// https://www.acmicpc.net/problem/1520

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;        // 지도 세로, 가로 크기
    static int[][] graph;   // 지도
    static int[][] dp;      // 각 지점에서 목표 지점까지의 경로 수
    static int[] dx = {0, 1, 0, -1}; // 상하좌우 이동
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        dp = new int[M][N];

        // 지도 높이 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    // dfs + 메모이제이션
    static int dfs(int x, int y) {
        // 목표 지점에 도달하면 경로 수는 1
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        // 이미 계산된 경우 dp 테이블 값 반환
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0; // 초기화

        // 상하좌우 탐색
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 유효 범위 내이고, 내리막길인 경우
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && graph[nx][ny] < graph[x][y]) {
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }
}
