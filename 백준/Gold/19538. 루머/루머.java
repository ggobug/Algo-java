// https://www.acmicpc.net/problem/19538
// 루머

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;   // 사람의 수, 최초 유포자 수, 1 <= M <= N <= 200_000
    static List<Integer>[] adjList;
    static int[] spreaders;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 루머 믿는 시간 배열 초기화
        time = new int[N + 1];
        Arrays.fill(time, -1);

        // 주변인 리스트 초기화
        adjList = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 주변인 정보 입력
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            while (true) {
                int idx = Integer.parseInt(st.nextToken()); // 주변인 번호
                if (idx == 0) break;    // 0이면 마지막
                adjList[i].add(idx);
            }
        }

        // 최초 유포자의 수와 번호 입력
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        spreaders = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            spreaders[i] = Integer.parseInt(st.nextToken());
        }

        // 루머 확산
        spreadRumor();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(time[i]).append(" ");
        }
        System.out.println(sb);
    }

    // BFS
    static void spreadRumor() {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] believer = new int[N + 1];    // 주변인 중 루머 믿는 사람 수

        // 최초유포자
        for (int spreader : spreaders) {
            que.add(spreader);
            time[spreader] = 0;
            visited[spreader] = true;
        }

        // 루머 확산
        while (!que.isEmpty()) {
            int cur = que.poll();
            int curTime = time[cur];

            for (int people : adjList[cur]) {
                if (visited[people]) continue;

                believer[people]++;

                if (believer[people] >= (adjList[people].size() + 1) / 2) {
                    que.add(people);
                    time[people] = curTime + 1;
                    visited[people] = true;
                }
            }
        }
    }
}
