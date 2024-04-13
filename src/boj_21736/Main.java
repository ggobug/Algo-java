package boj_21736;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];

        int sx = -1, sy = -1;
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = row.charAt(j);
                if (c == 'I') {
                    sx = i; sy = j;
                }
                arr[i][j] = c;
            }
        }

        boolean[][] visit = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();
        int ans = 0;

        visit[sx][sy] = true;
        que.add(new int[]{sx, sy});

        while (!que.isEmpty()) {
            int[] now = que.poll();

            if (arr[now[0]][now[1]] == 'P') {
                ans++;
            }

            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = now[0] + dx[i]; ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                    if (arr[nx][ny] == 'X') {
                        continue;
                    }
                    visit[nx][ny] = true;
                    que.add(new int[]{nx, ny});
                }
            }
        }
        if (ans == 0) {
            System.out.println("TT");
        } else {
            System.out.println(ans);
        }
    }
}
