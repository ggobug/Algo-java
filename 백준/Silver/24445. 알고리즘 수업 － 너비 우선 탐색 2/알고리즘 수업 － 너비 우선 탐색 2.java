import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;    // 정점의 수, 간선의 수
    static ArrayList<Integer>[] graph;
    static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());   // 시작 정점

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        // 방문 배열 초기화
        visited = new int[N + 1];

        // 간선 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 인접 정점은 내림차순 방문
        for (int i = 0; i <= N; i++) {
            graph[i].sort(Comparator.reverseOrder());
        }

        // 시작점
        int order = 1;
        visited[R] = order++;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);

        // 너비우선탐색
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                // 미방문 정점이면
                if (visited[next] == 0) {
                    visited[next] = order++;
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        // 결과 출력
        System.out.println(sb);

    }
}