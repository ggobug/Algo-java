package boj.pb_3584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int T, N, A, B, ans, root;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p;
            }

            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            findAncestor(A, B);
            System.out.println(ans);
        }
    }

    static void findAncestor(int a, int b) {

        // 가장 먼저 만나는 곳이 가장 가까운 공통 조상
        while (a > 0) {
            visited[a] = true;
            a = parent[a];
        }

        while (b > 0) {
            if (visited[b]) {
                ans = b;
                return;
            }
            visited[b] = true;
            b = parent[b];
        }
    }


}
