// 순열 사이클
// https://www.acmicpc.net/problem/10451

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());    // 순열의 크기

            // 그래프 초기화
            List<Integer>[] graph = new List[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            // 그래프 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int to = Integer.parseInt(st.nextToken());
                graph[i].add(to);
            }

            // 사이클 개수 찾기
            int cycleCount = countCycle(N, graph);
            sb.append(cycleCount).append("\n");
        }

        System.out.print(sb);
    }

    // 사이클 개수 찾는 함수
    public static int countCycle(int N, List<Integer>[] graph) {
        int count = 0;
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            // 미방문 노드에서 DFS 수행
            if (!visited[i]) {
                dfs(i, graph, visited);
                count++;
            }
        }
        return count;
    }

    // dfs 함수
    public static void dfs(int x, List<Integer>[] graph, boolean[] visited) {
        visited[x] = true;
        for (int next : graph[x]) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}
