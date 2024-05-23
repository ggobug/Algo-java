package boj.pb_1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;        // 집의 개수, 길의 개수
    static int[] parent;    // 부모
    static PriorityQueue<Node> pq;  // 비용 작은 순으로 오름차순 정렬

    static class Node implements Comparable<Node> {
        int s;
        int e;
        int cost;

        public Node(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) parent[i] = i;

        pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, c));
        }

        int ans = 0;
        int cnt = 0;

        while (cnt < N - 2) {
            Node now = pq.poll();
            int s = find(now.s);
            int e = find(now.e);

            if (s == e) continue;
            union(s, e);
            ans += now.cost;
            cnt++;
        }
        System.out.println(ans);
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}
