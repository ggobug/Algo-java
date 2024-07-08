// 촌수계산
// https://www.acmicpc.net/problem/2644

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 전체 사람 수 (정점 수)
        st = new StringTokenizer(br.readLine());
        int targetA = Integer.parseInt(st.nextToken());
        int targetB = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        boolean[][] edges = new boolean[n + 1][n + 1];

        int m = Integer.parseInt(st.nextToken());   // 관계의 개수 (간선 수)
        // 양방향 간선 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a][b] = true;
            edges[b][a] = true;
        }

        // 촌수 계산하기
        int[] visited = new int[n + 1];
        dfs(n, edges, visited, targetA, targetB);
        System.out.println((visited[targetB] != 0) ? visited[targetB] : -1);
    }

    static void dfs(int n, boolean[][] edges, int[] visited, int curPeople, int targetB) {
        // 목표 친척에 도달했으면
        if (curPeople == targetB) {
            return;
        }

        // 현재 사람과 부모자식 관계인 경우
        for (int i = 1; i < n + 1; i++) {
            if (edges[curPeople][i] && visited[i] == 0) {
                visited[i] = visited[curPeople] + 1;    // 방문 처리
                dfs(n, edges, visited, i, targetB);     // 재귀
            }
        }
    }
}
