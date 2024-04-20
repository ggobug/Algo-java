package boj.boj_2617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cnt, mid; // 구슬 개수, 쌍의 개수
    static ArrayList<Integer>[] heavy, light;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        heavy = new ArrayList[N];
        light = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            heavy[i] = new ArrayList<>();
            light[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            light[a - 1].add(b - 1);
            heavy[b - 1].add(a - 1);
        }

        cnt = 0;
        mid = (N + 1) / 2;
        check = new int[N];

        for (int i = 0; i < N; i++) {
            if (check[i] == 0) {
                bfs(i, light);
            }
            if (check[i] == 0) {
                bfs(i, heavy);
            }
        }

        System.out.println(cnt);

    }

    // 각 구슬에서 다른 구슬로 가는 최대 경로
    static void bfs(int start, ArrayList<Integer>[] arr) {
        int a = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        boolean[] visited = new boolean[N];
        visited[start] = true;
        while (!que.isEmpty()) {
            int s = que.poll();
            for (int t : arr[s]) {
                if (!visited[t]) {
                    que.add(t);
                    visited[t] = true;
                    a++;
                }
            }
        }
        if (a >= mid && check[start] == 0) {
            check[start] = 1;
            cnt++;
        }
    }

}
