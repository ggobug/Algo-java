import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 간선 그래프 초기화
        ArrayList<Integer>[] graphs = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }
        
        // 양방향 간선 정보 저장
        for (int[] vertexes : edge) {
            graphs[vertexes[0]].add(vertexes[1]);
            graphs[vertexes[1]].add(vertexes[0]);
        }
        
        // 1번 노드로부터 가장 먼 거리의 노드의 개수
        return bfs(n, graphs, 1);
    }

    public int bfs(int n, ArrayList<Integer>[] graphs, int startNode) {
        // 1번 노드에서 출발
        Queue<Integer> que = new LinkedList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        distance[startNode] = 0;
        que.add(startNode);

        while (!que.isEmpty()) {
            int curNode = que.poll();
            for (int nextNode : graphs[curNode]) {
                if (distance[nextNode] == -1) {
                    distance[nextNode] = distance[curNode] + 1;
                    que.add(nextNode);
                }
            }
        }

        int maxDistance = 0;
        int count = 0;
        for (int dist : distance) {
            if (dist > maxDistance) {
                maxDistance = dist;
                count = 1;
            } else if (dist == maxDistance) {
                count++;
            }
        }
        
        return count;
    }
}