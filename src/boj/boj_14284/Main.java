package boj.boj_14284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparator<Node> {
        int a;
        int b;
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return o1.b - o2.b;
        }
    }

    static int N; // 정점 개수
    static int M; // 간선 수

    static ArrayList<Node>[] graph;

    static int dijkstra(int a, int b) {
        PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.b - e2.b);
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[a] = 0;

        pq.add(new Node(a, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.a]) {
                continue;
            }

            visited[now.a] = true;

            for (Node next : graph[now.a]) {
                int nextDist = dist[now.a] + next.b;
                if (nextDist < dist[next.a]) {
                    dist[next.a] = nextDist;
                    pq.add(new Node(next.a, nextDist));
                }
            }
        }
        return dist[b];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph=new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(s, t));
    }
}
