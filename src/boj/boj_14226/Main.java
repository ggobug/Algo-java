package boj.boj_14226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int S;

    static class Emozi {
        int clipboard;
        int screen;
        int time;

        public Emozi(int clipboard, int screen, int time) {
            this.clipboard = clipboard;
            this.screen = screen;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        bfs(1);
    }

    // bfs
    static void bfs(int a) {
        Queue<Emozi> que = new LinkedList<>();
        que.add(new Emozi(0, 1, 0));
        boolean[][] visited = new boolean[2001][2001];
        visited[0][1] = true;

        while (!que.isEmpty()) {
            Emozi emozi = que.poll();

            if (emozi.screen == S) {
                System.out.println(emozi.time);
                System.exit(0);
            }

            if (emozi.screen <= 0) {
                continue;
            }

            if (emozi.clipboard < 0) {
                continue;
            }

            // 복사
            if (!visited[emozi.screen][emozi.screen]) {
                visited[emozi.screen][emozi.screen] = true;
                que.add(new Emozi(emozi.screen, emozi.screen, emozi.time + 1));
            }

            // 붙여넣기
            if (emozi.screen + emozi.clipboard < 2000 && !visited[emozi.clipboard][emozi.screen + emozi.clipboard]) {
                visited[emozi.clipboard][emozi.screen + emozi.clipboard] = true;
                que.add(new Emozi(emozi.clipboard, emozi.screen + emozi.clipboard, emozi.time + 1));
            }

            // 삭제
            if (!visited[emozi.clipboard][emozi.screen - 1]) {
                visited[emozi.clipboard][emozi.screen - 1] = true;
                que.add(new Emozi(emozi.clipboard, emozi.screen - 1, emozi.time + 1));
            }
        }
    }
}
