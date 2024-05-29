package boj.pb_14950;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, M, t;
    static int[] par;
    static ArrayList<Edge> graph;

    static class Edge implements Comparable<Edge> {
        int x, y;
        int distance;

        public Edge(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        // 초기화
        par = new int[N + 1];
        for (int i = 1; i <= N; i++) par[i] = i;

        graph = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Edge(a, b, c));
        }

        // 비용 오름차순 정렬
        Collections.sort(graph);

        int cost = 0;
        int count = 0;

        for (Edge edge : graph) {
            // 부모가 같지 않으면
            if (find(edge.x) != find(edge.y)) {
                union(edge.x, edge.y);
                cost += edge.distance + (count * t);
                count++;
                if (count == N - 1) break;
            }
        }
        System.out.println(cost);

    }

    static int find(int x) {
        if (par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) par[y] = x;
        else par[x] = y;
    }
}
