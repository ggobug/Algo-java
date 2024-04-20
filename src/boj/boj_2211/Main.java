package boj.boj_2211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] distance;
    static ArrayList<Node>[] graph;
    static int[] connection;
    static class Node implements Comparable<Node> {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return this.b - o.b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        dijkstra(1);

        sb.append(N - 1).append("\n");
        for (int i = 2; i <= N; i++) {
            sb.append(i).append(" ").append(connection[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(s, 0));
        distance = new int[N + 1];
        connection = new int[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[s] = 0;
        connection[s] = -1;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distance[now.a] < now.b) {
                continue;
            }

            for (Node next : graph[now.a]) {
                if (distance[next.a] <= now.b + next.b) {
                    continue;
                }
                connection[next.a] = now.a;
                distance[next.a] = now.b + next.b;
                pq.add(new Node(next.a, distance[next.a]));
            }
        }
    }
}
