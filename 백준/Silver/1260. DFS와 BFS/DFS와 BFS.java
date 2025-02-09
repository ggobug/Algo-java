import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, V;    // 정점의 개수, 간선의 개수, 시작 정점
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        N = Integer.parseInt(parts[0]);
        M = Integer.parseInt(parts[1]);
        V = Integer.parseInt(parts[2]);

        //그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        //간선 정보 입력 받기
        for (int i = 0; i < M; i++) {
            parts = br.readLine().split(" ");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            graph[from].add(to);
            graph[to].add(from);
        }
        //그래프 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        //깊이우선탐색
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        //너비우선탐색
        Arrays.fill(visited, false);
        bfs(V);

        //결과 출력
        System.out.println(sb);
    }

    //깊이우선탐색
    static void dfs(int node) {
        //노드 방문
        visited[node] = true;
        sb.append(node).append(" ");

        // 인접 노드 탐색
        for (int next : graph[node]) {
            if (visited[next]) continue;
            dfs(next);
        }
    }

    //너비우선탐색
    static void bfs(int node) {
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        visited[node] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            sb.append(cur).append(" ");

            for (int next : graph[cur]) {
                if (visited[next]) continue;
                que.add(next);
                visited[next] = true;
            }
        }
    }
}
