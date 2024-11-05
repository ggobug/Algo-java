import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static class Edge {
        int node;
        long dist;
        Edge(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static Map<Integer, List<Edge>> graph = new HashMap<>();
    static boolean[] visited;
    static int farthestNode;
    static long maxDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 그래프 생성
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            String[] parts = input.split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            long dist = Long.parseLong(parts[2]);

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Edge(b, dist));
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Edge(a, dist));
        }

        // 1. 임의의 점(1번 노드라고 가정)에서 가장 먼 노드를 찾는다.
        visited = new boolean[10001];
        maxDistance = 0;
        dfs(1, 0);

        // 2. 가장 먼 노드에서 다시 탐색하여 트리의 지름을 구한다.
        visited = new boolean[10001];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int node, long distance) { // 거리 파라미터도 long으로 변경
        visited[node] = true;
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }
        for (Edge edge : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited[edge.node]) {
                dfs(edge.node, distance + edge.dist);
            }
        }
    }
}
