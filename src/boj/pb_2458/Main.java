package boj.pb_2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[N + 1][N + 1];

        // O(M) : M개의 비교 결과를 읽어와서 그래프에 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // a보다 b가 더 크다
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
        }

        // 플로이드-워셜 알고리즘
        // O(N^3) : 모든 노드 쌍에 대한 경로를 계산
        // 500^3 = 125_000_000
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int count = 0;
        // O(N^2) : 각 학생이 다른 모든 학생과의 비교 결과를 확인
        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] || graph[j][i]) {
                    tmp++;
                }
            }
            if (tmp == N - 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
