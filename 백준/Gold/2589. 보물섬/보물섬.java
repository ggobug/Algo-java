import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static int maxDistance = Integer.MIN_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 지도 행
        M = Integer.parseInt(st.nextToken());   // 지도 열

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        // 모든 육지에서 BFS를 수행하여 최장 거리를 구함
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(maxDistance);
    }

    static void bfs(int x, int y) {
        int[][] visited = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        visited[x][y] = 1;
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (visited[nx][ny] == 0 && map[nx][ny] == 'L') {
                        visited[nx][ny] = visited[curX][curY] + 1;
                        queue.add(new int[]{nx, ny});
                        maxDistance = Math.max(maxDistance, visited[nx][ny] - 1); // 거리 계산
                    }
                }
            }
        }
    }
}
