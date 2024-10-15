import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to, maxCost, totalCost;

        public Node(int to, int maxCost, int totalCost) {
            this.to = to;
            this.maxCost = maxCost;
            this.totalCost = totalCost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.maxCost, other.maxCost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 교차로 개수
        int M = Integer.parseInt(st.nextToken());   // 골목 개수
        int A = Integer.parseInt(st.nextToken());   // 시작 교차로 번호
        int B = Integer.parseInt(st.nextToken());   // 도착 교차로 번호
        int C = Integer.parseInt(st.nextToken());   // 가진 돈

        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 골목 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost, 0));
            graph[to].add(new Node(from, cost, 0));
        }

        int result = dijkstra(graph, N, A, B, C);
        System.out.println(result);
    }

    static int dijkstra(List<Node>[] graph, int N, int start, int end, int budget) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq.offer(new Node(start, 0, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.to == end) {
                return current.maxCost;
            }

            for (Node next : graph[current.to]) {
                int newTotalCost = current.totalCost + next.maxCost;
                int newMaxCost = Math.max(current.maxCost, next.maxCost);

                if (newTotalCost <= budget && dist[next.to] > newMaxCost) {
                    dist[next.to] = newMaxCost;
                    pq.offer(new Node(next.to, newMaxCost, newTotalCost));
                }
            }
        }
        return -1;
    }
}
