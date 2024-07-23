// 적록색약
// https://www.acmicpc.net/problem/10026

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] colors = new char[N][N];
        char[][] colorsRedGreen = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                colors[i][j] = line[j];
                if (line[j] == 'G') {
                    colorsRedGreen[i][j] = 'R'; // 'G'를 'R'로 저장
                } else {
                    colorsRedGreen[i][j] = line[j];
                }
            }
        }
        System.out.println(bfs(colors) + " " + bfs(colorsRedGreen));
    }

    static int bfs(char[][] graph) {
        int sectorCnt = 0;
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                // 미방문 구역
                if (!visited[i][j]) {
                    sectorCnt++;
                    visited[i][j] = true;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];

                            // 범위 벗어나면 제외
                            if (nx <0 || nx >=N || ny < 0 || ny >= N) continue;

                            // 범위에 들어가고, 미방문, 이전과 색깔이 같으면
                            if (!visited[nx][ny] && graph[nx][ny] == graph[cur[0]][cur[1]]) {
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return sectorCnt;
    }
}
