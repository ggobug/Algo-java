// 트리의 지름
// https://www.acmicpc.net/problem/1167

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int farthestNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        // 그래프 초기화
        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        // 그래프 입력
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                tree[from].add(new Node(to, dist));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int node, int distance) {
        visited[node] = true;
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }
        for (Node next : tree[node]) {
            if (!visited[next.to]) {
                dfs(next.to, distance + next.dist);
            }
        }
    }

    static class Node {
        int to, dist;

        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}