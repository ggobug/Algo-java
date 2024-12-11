import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] farm;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 농장 정보 입력 받기
        farm = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 산봉우리 개수 찾기
        System.out.println(findPeaks());
    }

    static int findPeaks() {
        visited = new boolean[N][M];
        int peakCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && bfs(i, j)) {
                    peakCount++;
                }
            }
        }
        return peakCount;
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        boolean isPeak = true;
        int height = farm[x][y];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 8; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (farm[nx][ny] > height) {
                        isPeak = false;
                    }

                    if (!visited[nx][ny] && farm[nx][ny] == height) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return isPeak;
    }

    static boolean dfs(int x, int y) {
        visited[x][y] = true;
        boolean isPeak = true;
        int height = farm[x][y];

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (farm[nx][ny] > height) {
                    isPeak = false;
                }

                if (!visited[nx][ny] && farm[nx][ny] == height) {
                    if (!dfs(nx, ny)) {
                        isPeak = false;
                    }
                }
            }
        }
        return isPeak;
    }
}