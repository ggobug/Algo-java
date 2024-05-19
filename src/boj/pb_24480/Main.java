package boj.pb_24480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n, m, order;
    static int[] orders;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());   // 시작 정점

        graph = new ArrayList[n + 1];
        orders = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(Collections.reverseOrder());
        }

        order = 1;
        dfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(orders[i]);
        }
    }
    static void dfs(int x) {
        visited[x] = true;
        orders[x] = order++;

        for (int v : graph[x]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
}
