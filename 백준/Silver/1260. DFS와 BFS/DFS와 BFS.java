// DFS와 BFS
// https://www.acmicpc.net/problem/1260

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 정점의 수
        int M = Integer.parseInt(st.nextToken());   // 간선의 수
        int V = Integer.parseInt(st.nextToken());   // 시작 정점
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        List<Integer> dfsOrder = dfs(N, M, V, graph);
        List<Integer> bfsOrder = bfs(N, M, V, graph);

        StringBuilder sb = new StringBuilder();
        for (int num : dfsOrder) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
        for (int num : bfsOrder) {
            sb.append(num).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);

    }

    static List<Integer> dfs(int N, int M, int V, ArrayList<Integer>[] graph) {
        boolean[] visited = new boolean[N + 1];
        List<Integer> order = new ArrayList<>();
        dfsRecur(V, graph, visited, order);
        return order;
    }

    static void dfsRecur(int v, ArrayList<Integer>[] graph, boolean[] visited, List<Integer> order) {
        visited[v] = true;
        order.add(v);
        for (int next : graph[v]) {
            if (!visited[next]) {
                dfsRecur(next, graph, visited, order);
            }
        }
    }

    static List<Integer> bfs(int N, int M, int V, ArrayList<Integer>[] graph) {
        boolean[] visited = new boolean[N + 1];
        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            order.add(v);

            for (int next : graph[v]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return order;
    }
}

