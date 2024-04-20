package boj.boj_24230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] curColors, lastColors;
    static ArrayList<Integer>[] tree;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        curColors = new int[N];
        lastColors = new int[N];
        tree = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lastColors[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            tree[a].add(b);
            tree[b].add(a);
        }

        // 루트 노드 찾기
        int root = findRoot();

        bfs(root);
        System.out.println(count);
    }

    static int findRoot() {

        for (int i = 0; i < N; i++) {
            int visitCnt = 0;
            boolean[] visited = new boolean[N];
            Queue<Integer> que = new LinkedList<>();

            que.add(i);
            visited[i] = true;
            visitCnt = 1;

            while (!que.isEmpty()) {
                int now = que.poll();
                for (int next : tree[now]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        que.add(next);
                        visitCnt++;
                    }
                }
            }

            if (visitCnt == N) {
                return i;
            }
        }
        return -1;
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N];
        int preColor = lastColors[start];
        curColors[start] = lastColors[start];

        if (preColor != 0) {
            count++;
        }

        que.add(start);
        visited[start] = true;

        while (!que.isEmpty()) {

            int cur = que.poll();
            int parColor = curColors[cur];

            for (int next : tree[cur]) {
                if (!visited[next]) {

                    // 부모 노드와 색깔 맞추기
                    if (curColors[next] != lastColors[next]) {
                        if (parColor != lastColors[next]) {
                            curColors[next] = lastColors[next];
                            count++;
                        } else {
                            curColors[next] = parColor;
                        }
                    }
                    visited[next] = true;
                    que.add(next);
                }
            }
        }
    }
}
