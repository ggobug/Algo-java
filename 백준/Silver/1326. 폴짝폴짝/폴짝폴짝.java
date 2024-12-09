// 폴짝폴짝
// https://www.acmicpc.net/problem/1326

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 징검다리 개수
        int[] arr = new int[N];     // 징검다리에 쓰여있는 숫자들의 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int goal = Integer.parseInt(st.nextToken()) - 1;

        int result = bfs(N, arr, start, goal);
        System.out.println(result);
    }

    // bfs
    static int bfs(int N, int[] arr, int start, int goal) {
        // 큐, 방문여부 배열 초기화
        Queue<int[]> que = new LinkedList<>();
        boolean[] visited = new boolean[N];
        que.add(new int[]{start, 0});
        visited[start] = true;

        // 탐색 시작
        while (!que.isEmpty()) {
            int[] curInfo = que.poll();
            int cur = curInfo[0];

            // 목표 지점 도달하면 이동횟수 반환
            if (cur == goal) {
                return curInfo[1];
            }

            int next;
            for (int i = 0; i < N; i++) {
                next = i;
                if (Math.abs(next - cur) % arr[cur] == 0 && !visited[next]) { // 징검다리 수의 배수만큼 떨어져 있으면
                    que.add(new int[]{next, curInfo[1] + 1});
                    visited[next] = true;
                }
            }
        }

        // 목표 지점에 도달 못하면 -1 반환
        return -1;
    }
}
