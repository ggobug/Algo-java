import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        final int INF = Integer.MAX_VALUE;
        
        // 인접 리스트
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // 다익스트라
        int[] distances = dijkstra(graph, n, destination, INF);
        
        // 각 출발지점에서 목적지까지의 최단 거리
        int[] result = new int[sources.length];
        for (int i = 0; i< sources.length; i++) {
            int source = sources[i];
            if (distances[source] == INF) result[i] = -1;
            else result[i] = distances[source];
        }
        return result;
    }
    
    // 다익스트라 알고리즘
    private static int[] dijkstra(List<List<Integer>> graph, int n, int start, int INF) {
        // 거리 초기화
        int[] distances = new int[n + 1];
        Arrays.fill(distances, INF);
        distances[start] = 0;
        
        // 우선순위큐 초기화
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, start});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curDistance = cur[0];
            int curNode = cur[1];
            
            // 현재 노드까지 온 거리가 최단 경로가 아니면 패스
            if (curDistance > distances[curNode]) continue;
            
            for (int nextNode : graph.get(curNode)) {
                int distance = curDistance + 1;
                if (distance >= distances[nextNode]) continue;
                distances[nextNode] = distance;
                pq.add(new int[]{distance, nextNode});
            }
        }   
        return distances;
    }
}