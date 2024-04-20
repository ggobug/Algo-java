package boj.boj_12761;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());    // 동규 현재 위치
        int M = Integer.parseInt(st.nextToken());    // 주미 현재 위치

        // BFS
        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();

        int[] choices = {1, -1, A, -A, B, -B};

        // 초기 동규 위치 저장
        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            // 0보다 작거나 100000보다 크면 안됨
            if (now < 0 || now > 100000) {
                continue;
            }

            // 주미의 위치에 도달하면 종료
            if (now == M) {
                System.out.println(visited[now] - 1);
                return;
            }

            for (int choice : choices) {
                int next = now + choice;
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }

            int next = now * A;
            if (next >= 0 && next <= 100000 && visited[next] == 0) {
                visited[next] = visited[now] + 1;
                queue.add(next);
            }
            next = now * B;
            if (next >= 0 && next <= 100000 && visited[next] == 0) {
                visited[next] = visited[now] + 1;
                queue.add(next);
            }


        }
    }
}
