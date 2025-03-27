// 이분그래프 (Bipartite Graph)
// https://www.acmicpc.net/problem/1707

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int V, E; // 정점의 개수, 간선의 개수
    static ArrayList<Integer>[] graph;
    static int[] color; // 0: 미방문, 1: 그룹 A, 2: 그룹 B

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        // 테스트 케이스
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            // 그래프 초기화
            graph = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            // 간선 정보 입력
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            color = new int[V + 1];
            boolean isBipartite = true;

            // 연결 그래프가 아닐 수 있으므로 모든 정점 검사
            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }


    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1; // 1번 색으로 시작

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (color[next] == 0) {
                    color[next] = 3 - color[now]; // 1 -> 2, 2 -> 1
                    queue.add(next);
                } else if (color[next] == color[now]) {
                    return false;
                }
            }
        }

        return true;
    }

}
