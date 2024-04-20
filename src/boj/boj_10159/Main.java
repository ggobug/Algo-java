package boj.boj_10159;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, mid, cnt;   // 물건의 개수, 미리 측정된 물건 쌍의 개수
    static ArrayList<Integer>[] heavy, light;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        heavy = new ArrayList[N]; light = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            heavy[i] = new ArrayList<>();
            light[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            light[a].add(b);
            heavy[b].add(a);
        }


        // 너비 탐색을 하면서 무게 비교
        for (int i = 0; i < N; i++) {
            int count = N - 1;
            count -= bfs(i, light);
            count -= bfs(i, heavy);
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int start, ArrayList<Integer>[] arr) {
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N];
        que.add(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : arr[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.add(next);
                    cnt++;
                    if (!arr[start].contains(next)) {
                        arr[start].add(next);
                    }
                }
            }
        }

        return cnt;

    }
}
