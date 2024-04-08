package boj_14923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] maze;
    static int[] start = new int[2];
    static int[] goal = new int[2];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];

        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken()) - 1;
        start[1] = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        goal[0] = Integer.parseInt(st.nextToken()) - 1;
        goal[1] = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        // bfs 0-1
        // 가중치 0과 1
        Queue<int[]> que = new LinkedList<>();
        int[][][] visited = new int[N][M][2];

        visited[start[0]][start[1]][0] = 1;
        visited[start[0]][start[1]][1] = 0;
        int[] init = new int[3];
        init[0] = start[0];
        init[1] = start[1];
        init[2] = 0;
        que.add(init);

        while (!que.isEmpty()) {
            int[] now = que.poll();

            // 탈출 위치에 도착하면 종료
            if (now[0] == goal[0] && now[1] == goal[1]) {
//                printArray(visited);
                System.out.println(visited[goal[0]][goal[1]][0] - 1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (visited[nx][ny][0] == 0 || (visited[nx][ny][1] == 1 && now[2] == 0)) {
                        // 벽을 만나고 뚫을 수 있으면
                        if (maze[nx][ny] == 1 && now[2] == 0) {
                            visited[nx][ny][0] = visited[now[0]][now[1]][0] + 1;
                            visited[nx][ny][1] = 1;
                            int[] next = new int[3];
                            next[0] = nx;
                            next[1] = ny;
                            next[2] = 1;
                            que.add(next);
                        } else if (maze[nx][ny] == 0) {
                            visited[nx][ny][0] = visited[now[0]][now[1]][0] + 1;
                            visited[nx][ny][1] = now[2];
                            int[] next = new int[3];
                            next[0] = nx;
                            next[1] = ny;
                            next[2] = now[2];
                            que.add(next);
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static void printArray(int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

