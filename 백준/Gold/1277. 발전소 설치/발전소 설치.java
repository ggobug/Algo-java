import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, W;    // 발전소의 수, 전선의 수
    static double M;    // 제한 길이
    static int[][] powerStation;    // 발전소 좌표
    static List<double[]>[] adj;    // 전선 추가 가능한 인접 발전소 리스트
    static double[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        N = Integer.parseInt(parts[0]);
        W = Integer.parseInt(parts[1]);
        M = Double.parseDouble(br.readLine());

        // 발전소 배열 초기화
        powerStation = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            String[] coords = br.readLine().split(" ");
            powerStation[i][0] = Integer.parseInt(coords[0]);
            powerStation[i][1] = Integer.parseInt(coords[1]);
        }

        // 인접리스트 초기화
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 설치된 전선 입력 받기
        for (int i = 1; i <= W; i++) {
            String[] powers = br.readLine().split(" ");
            int a = Integer.parseInt(powers[0]);
            int b = Integer.parseInt(powers[1]);
            adj[a].add(new double[]{b, 0});
            adj[b].add(new double[]{a, 0});
        }

        // 발전소간 거리 측정
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double dist = calculateDistance(powerStation[i], powerStation[j]);

                if (dist > M) continue;

                adj[i].add(new double[]{j, dist});
                adj[j].add(new double[]{i, dist});
            }
        }

        double MAX_VALUE = 300_000D;

        distance = new double[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(distance, MAX_VALUE);
        distance[1] = 0;

        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o[1]));
        pq.offer(new double[]{1, 0});

        // 1번 발전소에서 출발
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int curPower = (int) cur[0];
            double curDist = cur[1];

            if (visited[curPower]) continue;
            visited[curPower] = true;

            for (double[] next : adj[curPower]) {
                int nextPower = (int) next[0];
                double nextDist = next[1];

                if (distance[nextPower] <= curDist + nextDist) continue;

                distance[nextPower] = curDist + nextDist;
                pq.add(new double[]{nextPower, distance[nextPower]});
            }
        }

        if (distance[N] == MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println((int)(distance[N] * 1000));
        }
    }

    static double calculateDistance(int[] powerA, int[] powerB) {
        long dx = powerA[0] - powerB[0];
        long dy = powerA[1] - powerB[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
}
