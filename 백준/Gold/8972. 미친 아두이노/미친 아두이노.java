import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static int R, C;
    static char[][] board;
    static List<int[]> crazyList = new ArrayList<>();
    static int[] jongsu = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        // 보드 및 위치 초기화
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'I') {
                    jongsu[0] = i;
                    jongsu[1] = j;
                } else if (board[i][j] == 'R') {
                    crazyList.add(new int[]{i, j});
                }
            }
        }

        char[] moves = br.readLine().toCharArray();

        for (int turn = 0; turn < moves.length; turn++) {
            int dir = moves[turn] - '1';
            int nx = jongsu[0] + dx[dir];
            int ny = jongsu[1] + dy[dir];

            // 종수 이동
            if (board[nx][ny] == 'R') {
                System.out.println("kraj " + (turn + 1));
                return;
            }

            board[jongsu[0]][jongsu[1]] = '.';
            jongsu[0] = nx;
            jongsu[1] = ny;
            board[nx][ny] = 'I';

            // 미친 아두이노 이동 준비
            Map<String, List<int[]>> nextCrazy = new HashMap<>();

            for (int[] c : crazyList) {
                int minDist = Integer.MAX_VALUE;
                int cx = 0, cy = 0;

                for (int d = 0; d < 9; d++) {
                    int tx = c[0] + dx[d];
                    int ty = c[1] + dy[d];
                    if (tx < 0 || ty < 0 || tx >= R || ty >= C) continue;
                    int dist = Math.abs(jongsu[0] - tx) + Math.abs(jongsu[1] - ty);
                    if (dist < minDist) {
                        minDist = dist;
                        cx = tx;
                        cy = ty;
                    }
                }

                if (cx == jongsu[0] && cy == jongsu[1]) {
                    System.out.println("kraj " + (turn + 1));
                    return;
                }

                String key = cx + "," + cy;
                nextCrazy.putIfAbsent(key, new ArrayList<>());
                nextCrazy.get(key).add(new int[]{cx, cy});
            }

            // 보드 초기화
            for (int[] c : crazyList) {
                board[c[0]][c[1]] = '.';
            }

            crazyList.clear();

            // 충돌 확인
            for (Map.Entry<String, List<int[]>> entry : nextCrazy.entrySet()) {
                if (entry.getValue().size() == 1) {
                    int[] pos = entry.getValue().get(0);
                    crazyList.add(pos);
                    board[pos[0]][pos[1]] = 'R';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(board[i]).append('\n');
        }
        System.out.print(sb);
    }
}