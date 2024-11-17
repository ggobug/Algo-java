import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;        // 위험한 구역, 죽음의 구역의 수
    static int[][] graph;   // 지역
    static int[][] costs;   // 생명력 손실 비용
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int size = 501;
        graph = new int[size][size];
        costs = new int[size][size];
        for (int[] row : costs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // 위험 구역 입력 받기
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int minX = Math.min(x1, x2);
            int maxX = Math.max(x1, x2);
            int minY = Math.min(y1, y2);
            int maxY = Math.max(y1, y2);
            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    graph[x][y] = 1;
                }
            }
        }

        // 죽음 구역 입력 받기
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int minX = Math.min(x1, x2);
            int maxX = Math.max(x1, x2);
            int minY = Math.min(y1, y2);
            int maxY = Math.max(y1, y2);
            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    graph[x][y] = 2;
                }
            }
        }

        // (0, 0)에서 (500, 500)까지 최소한의 생명력으로 이동하기
        // 다익스트라 알고리즘 실행
        int result = dijkstra(0, 0, 500, 500);
        System.out.println(result);
    }

    // 다익스트라 알고리즘
    static int dijkstra(int startX, int startY, int endX, int endY) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, startX, startY});
        costs[startX][startY] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int x = current[1];
            int y = current[2];

            // 목표 구역 도착
            if (x == endX && y == endY) return cost;

            // 최단 경로만 체크
            if (cost > costs[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx > 500 || ny > 500) continue;
                int newCost = cost;
                if (graph[nx][ny] == 1) newCost += 1;   // 위험 구역
                if (graph[nx][ny] == 2) continue;       // 죽음 구역

                if (newCost < costs[nx][ny]) {
                    costs[nx][ny] = newCost;
                    pq.add(new int[]{newCost, nx, ny});
                }
            }

        }
        return -1; // 도달 불가
    }
}

