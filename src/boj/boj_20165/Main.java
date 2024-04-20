package boj.boj_20165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;   // 행의 개수
    static int M;   // 열의 개수
    static int R;   // 라운드 횟수

    static int[][] board;
    static int cnt;

    static Map<Character, int[]> directions = new HashMap<>();

    /*
    * 1. 각 도미노는 1이상 5이하의 높이를 가진다.
    * 2. 매 라운드 공격수가 먼저 공격, 수비수는 공격이 끝난 뒤에 수비
    * 3. 동서남북 중 원하는 방향으로 넘어뜨린다.
    *   길이가 K인 도미노가 특정 방향으로 넘어지면,
    *   그 방향으로 K-1 개의 도미노들 중에 아직 넘어지지 않은 것들이 같은 방향으로 연달아 넘어진다.
    * 4. 수비수는 넘어져 있는 도미노들 중, 원하는 것 하나를 다시 세울 수 있다.
    *   넘어지지 않은 도미노를 세우려 하면 아무 일도 일어나지 않는다.
    * 5. 총 R 번의 라운드동안 3, 4번 과정이 반복된다.
    *   매 라운드마다 공격수가 넘어뜨린 도미노의 개수를 세고
    *   총합이 곧 공격수의 점수가 된다.
    * -------------------------------
    * 공격수의 점수를 출력
    */

    public static void main(String[] args) throws IOException {
        // 방향 저장
        directions.put('E', new int[]{0, 1});
        directions.put('W', new int[]{0, -1});
        directions.put('S', new int[]{1, 0});
        directions.put('N', new int[]{-1, 0});

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        // 초기 보드판 상태 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalCount = 0;

        // 각 라운드 공격수, 수비수의 행동
        for (int i = 0; i < R; i++) {
            cnt = 0;
            for (int t = 0; t < 2; t++) {
                st = new StringTokenizer(br.readLine());

                int r = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken())-1;

                // 공격수라면
                if (t == 0) {
                    char d = st.nextToken().charAt(0);
                    attack(r, c, d);
                    continue;
                }
                defense(r, c);
            }
            totalCount += cnt;
        }

        System.out.println(totalCount);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0) {
                    System.out.print("S");
                } else {
                    System.out.print("F");
                }
                if (j != M-1) {
                    System.out.print(" ");
                }
            }
            if (i != N-1) {
                System.out.println();
            }
        }
    }

    // 공격수 행동
    public static void attack(int r, int c, char d) {
        int[] direction = directions.get(d);

        // 이미 넘어뜨린 도미노를 넘어뜨리려 하는 경우
        if (r < 0 || r >= N || c < 0 || c >= M || board[r][c] < 0) {
            return;
        }

        int size = board[r][c];

        board[r][c] *= -1;
        cnt++;

        // 도미노 넘어뜨리기
        for (int s = 1; s < size; s++) {
            int nr = r + s * direction[0];
            int nc = c + s * direction[1];
            attack(nr, nc, d);
        }
    }

    public static void defense(int r, int c) {
        // 도미노 세우기
        if (board[r][c] < 0) {
            board[r][c] *= -1;
        }
    }
}
