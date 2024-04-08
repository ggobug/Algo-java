package boj_14496;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] visited = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            graph[p - 1].add(q - 1);
            graph[q - 1].add(p - 1);
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(a);
        visited[a] = 1;
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if (visited[next] == 0) {
                    que.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }

        int ans = visited[b] == 0 ? -1 : visited[b] - 1;
        System.out.println(ans);

    }
}
