import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;    // 미로의 크기
    static int[][] maze;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        // bfs
        Queue<int[]> que = new LinkedList<>();
        int[][] visited = new int[N][M];

        que.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] != 0 || maze[nx][ny] == 0) continue;

                que.add(new int[]{nx, ny});
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
            }
        }
        System.out.println(visited[N - 1][M - 1]);
    }
}
