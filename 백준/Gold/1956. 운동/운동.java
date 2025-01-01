// 운동
// https://www.acmicpc.net/problem/1956

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());   // 마을 수
        int E = Integer.parseInt(st.nextToken());   // 도로 수

        int[][] dist = new int[V + 1][V + 1];

        // 초기화
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        // 도로 정보 입력 받기
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = c; // 일방 통행
        }

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 최소 사이클 찾기
        int minCycle = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j && dist[i][j] != INF && dist[j][i] != INF) {
                    minCycle = Math.min(minCycle, dist[i][j] + dist[j][i]);
                }
            }
        }

        // 결과 출력
        System.out.println(minCycle == INF ? -1 : minCycle);
    }
}
