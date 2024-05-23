package boj.pb_13459;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;    // 보드의 가로, 세로
    static char[][] board;
    static int[] red, blue;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean possible = false;
    static boolean[][][][] visited;

    // 빨간 구슬을 구멍을 통해 빼내기
    // 파란 구슬이 구멍에 들어가면 안 된다.
    // 10번 이하로 빨간 구슬을 빼낼 수 있는가
    // 더이상 움직이지 않을 때까지 기울기지 동작

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[11][11][11][11];

        red = new int[2];
        blue = new int[2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                    board[i][j] = '.';
                }
            }
        }
//        System.out.println("red[0] + red[1] = " + red[0] + " " + red[1]);
//        System.out.println("blue[0] + blue[1] = " + blue[0] + " " + blue[1]);
        bfs();
        System.out.println(possible ? 1 : 0);
    }

    private static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{red[0], red[1], blue[0], blue[1], 0});
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;

        while (!que.isEmpty()) {
            int[] position = que.poll();
            int rx = position[0];
            int ry = position[1];
            int bx = position[2];
            int by = position[3];
            int depth = position[4];

//            System.out.println("rx, ry = " + rx + " " + ry);
//            System.out.println("bx, by = " + bx + " " + by);

            if (depth >= 10) return;


            // 기울이기
            for (int i = 0; i < 4; i++) {
                // 우 하 좌 상
                int[] newPosition = tilt(rx, ry, bx, by, i);
                int nrx = newPosition[0];
                int nry = newPosition[1];
                int nbx = newPosition[2];
                int nby = newPosition[3];

                if (board[nbx][nby] == 'O') continue;   // 파란 구슬이 구멍에 빠지면 실패
                if (board[nrx][nry] == 'O') {           // 빨간 구슬이 구멍에 빠지면 성공
//                    System.out.println("nrx + nry = " + nrx + " " + nry);
//                    System.out.println("nbx + nby = " + nbx + " " + nby);
                    possible = true;
                    return;
                }

                // 미방문
                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    que.add(new int[]{nrx, nry, nbx, nby, depth + 1});
                }
            }
        }

    }

    // 기울이기
    private static int[] tilt(int rx, int ry, int bx, int by, int direction) {
        int nrx = rx, nry = ry, nbx = bx, nby = by;
        boolean redFirst = true;   // 빨간 공 먼저 굴리나 ?

        if (direction == 0 && ry < by) redFirst = false;
        if (direction == 1 && rx < bx) redFirst = false;
        if (direction == 2 && ry > by) redFirst = false;
        if (direction == 3 && rx > bx) redFirst = false;

        // 빨간 공 먼저 굴리는 경우
        if (redFirst) {
            int[] nR = move(rx, ry, direction, bx, by);
            nrx = nR[0];
            nry = nR[1];
            int[] nB = move(bx, by, direction, nrx, nry);
            nbx = nB[0];
            nby = nB[1];
        }
        // 파란 공 먼저 굴리는 경우
        else {
            int[] nB = move(bx, by, direction, rx, ry);
            nbx = nB[0];
            nby = nB[1];
            int[] nR = move(rx, ry, direction, nbx, nby);
            nrx = nR[0];
            nry = nR[1];
        }

        // 두 공이 같은 위치에 있을 때
        if (nrx == nbx && nry == nby && board[nrx][nry] != 'O') {
            if (direction == 0) {           // 오른쪽
                if (ry < by) nry--;
                else nby++;
            } else if (direction == 1) {    // 아래쪽
                if (rx < bx) nrx--;
                else nbx++;
            } else if (direction == 2) {    // 왼쪽
                if (ry > by) nry++;
                else nby--;
            } else if (direction == 3) {    // 위쪽
                if (rx > bx) nrx++;
                else nbx--;
            }
        }

        return new int[]{nrx, nry, nbx, nby};
    }

    private static int[] move(int x, int y, int direction, int ox, int oy) {
        int nx = x, ny = y;
        while (true) {
            int nextX = nx + dx[direction];
            int nextY = ny + dy[direction];
            if (board[nextX][nextY] == '#') break;
            if (board[nextX][nextY] != 'O' && (nextX == ox && nextY == oy)) break;
            nx = nextX;
            ny = nextY;
            if (board[nx][ny] == 'O') break;
        }
        return new int[]{nx, ny};
    }
}
