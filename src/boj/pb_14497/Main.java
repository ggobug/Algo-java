package boj.pb_14497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, x1, y1, x2, y2;
    static char[][] arr;
    static int[][] distance;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, -0};

    static class Node implements Comparable<Node>{
        int x, y, jump;

        public Node(int x, int y, int jump) {
            this.x = x;
            this.y = y;
            this.jump = jump;
        }

        @Override
        public int compareTo(Node o) {
            return this.jump - o.jump;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 주난이 위치
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y1 = Integer.parseInt(st.nextToken()) - 1;

        //범인의 위치
        x2 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;

        arr = new char[n][m];
        distance = new int[n][m];

        for (int[] ints : distance) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        dijkstra();
        System.out.println(distance[x2][y2] + 1);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[x1][y1] = 0;
        pq.add(new Node(x1, y1, distance[x1][y1]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (distance[cur.x][cur.y] < cur.jump) continue;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                int cost = (arr[nx][ny] != '1') ? 0 : 1;

                if (distance[nx][ny] <= cur.jump + cost) continue;

                distance[nx][ny] = cur.jump + cost;
                pq.add(new Node(nx, ny, distance[nx][ny]));
            }
        }
    }
}
