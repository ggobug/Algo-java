package boj.boj_10282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 다익스트라 뭔데..

    static int N; // 컴퓨터 개수
    static int D; // 의존성 개수
    static int C; // 해킹 당한 컴퓨터 개수
    static int count; // 총 감영되는 컴퓨터 수
    static int[] time; // 가중치
    static List<ArrayList<int[]>> graph;

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); // 우선순위 지정
        pq.add(new int[]{C, 0});


        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (time[now[0]] < now[1]) continue;
            count++;

            for (int i = 0; i < graph.get(now[0]).size(); i++) {
                int[] next = graph.get(now[0]).get(i);

                if (time[next[0]] > time[now[0]] + next[1]) {
                    time[next[0]] = time[now[0]] + next[1];
                    int[] tmp2 = {next[0], time[next[0]]};
                    pq.add(tmp2);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph.get(b).add(new int[]{a, c});
            }

            time = new int[N + 1];
            Arrays.fill(time, Integer.MAX_VALUE);
            time[C] = 0;

            dijkstra();

            int count = 0;
            int maxTime = 0;

            for (int i = 1; i <= N; i++) {
                if (time[i] != Integer.MAX_VALUE) {
                    count++;
                    maxTime = Math.max(maxTime, time[i]);
                }
            }

            System.out.println(count + " " + maxTime);
        }
    }
}
