import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] board = new char[8][8];
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1, 0};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
        }

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{7, 0, 0});

        while (!que.isEmpty()) {
            int size = que.size();
            boolean[][] visited = new boolean[8][8];

            // 현재 순간 가능한 모든 위치 탐색
            for (int s = 0; s < size; s++) {
                int[] cur = que.poll();
                int x = cur[0], y = cur[1], time = cur[2];

                // 목적지 도착 시 즉시 종료
                if (x == 0 && y == 7) {
                    System.out.println(1);
                    return;
                }

                // 벽이 현재 위치에 있으면 움직일 수 없음
                if (board[x][y] == '#') continue;

                for (int i = 0; i < 9; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue; // 범위 초과
                    if (board[nx][ny] == '#') continue; // 벽이면 이동 불가
                    if (visited[nx][ny]) continue; // 방문한 곳은 중복 이동 X

                    visited[nx][ny] = true;
                    que.add(new int[]{nx, ny, time + 1});
                }
            }

            moveWalls();
        }

        System.out.println(0);
    }

    // 벽을 한 칸 아래로 이동시키는 함수
    static void moveWalls() {
        for (int i = 7; i > 0; i--) {
            board[i] = board[i - 1].clone();
        }
        board[0] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.'};
    }
}
