package boj_11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static char[][] field = new char[12][6];
    static Queue<int[]> target = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                field[i][j] = line.charAt(j);
            }
        }
        bfs();

        System.out.println(count);
//        for (char[] chars : field) {
//            for (char aChar : chars) {
//                System.out.print(aChar);
//            }
//            System.out.println();
//        }
    }

    // 뿌요 폭발
    static void boom() {
        // 폭발
        while (!target.isEmpty()) {
            int[] pt = target.poll();
            field[pt[0]][pt[1]] = '.';
        }
    }

    //드롭
    static void drop() {
        // 드롭
        for (int j = 0; j < 6; j++) {
            char[] temp = new char[12];
            int idx = 11;
            Arrays.fill(temp, '.');
            for (int i = 11; i >= 0; i--) {
                if (field[i][j] != '.') {
                    temp[idx--] = field[i][j];
                }
            }
            // 복사
            for (int i = 0; i < 12; i++) {
                field[i][j] = temp[i];
            }
        }
    }

    // bfs, 인접 뿌요 탐색
    static void bfs() {
        boolean isBoom = false;
        visited = new boolean[12][6];
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                // 방문하지 않은 뿌요
                if (field[i][j] != '.' && visited[i][j] == false) {
                    char color = field[i][j];
                    visited[i][j] = true;
                    int[] point = {i, j};
                    que.add(point);
                    target.add(point);

                    while (!que.isEmpty()) {
                        int[] now = que.poll(); // 현재 위치
                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6) {
                                if (field[nx][ny] == color && visited[nx][ny] == false) {
                                    visited[nx][ny] = true;
                                    int[] pt = {nx, ny};
                                    que.add(pt);
                                    target.add(pt);
                                }
                            }
                        }
                    }
                    // 더이상 전진할 곳이 없고, 4개 이상 인접 해있는 경우
                    if (target.size() >= 4) {
                        boom();
                        isBoom = true;

                    } else {
                        target.clear();
                    }
                }
            }
        }
        if (isBoom) {
            drop();
            count++;
            bfs();
        }
    }


}
