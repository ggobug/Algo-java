import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;    // 상자의 가로, 세로 칸 수
    static int[][] box; // 박스
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
        * 1 : 익은 토마토
        * 0 : 익지 않은 토마토
        * -1 : 토마토가 들어있지 않음
        */
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 초기화
        box = new int[N][M];
        visited = new int[N][M];
        Queue<int[]> que = new LinkedList<>();

        int emptyCnt = 0;
        // 토마토 위치, 상태 정보 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    que.add(new int[]{i, j});   // 익은 토마토 위치 저장
                    visited[i][j] = 1;
                } else if (box[i][j] == -1) emptyCnt++;
            }
        }
        int ripeCnt = 0;
        while (!que.isEmpty()) {
            int[] curTomato = que.poll();
            ripeCnt++;
            if (ripeCnt == M * N - emptyCnt) {
                System.out.println(visited[curTomato[0]][curTomato[1]] - 1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = curTomato[0] + dx[d];
                int ny = curTomato[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                // 미방문, 익지 않은 토마토가 근처에 있으면
                if (visited[nx][ny] == 0 && box[nx][ny] == 0) {
                    que.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[curTomato[0]][curTomato[1]] + 1;
                }
            }
        }
        System.out.println(-1);
    }
}
