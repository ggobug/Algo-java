import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] results) {
        /*
        1. 승, 패로 단방향 그래프 생성
        2. 시작노드에서 각 승, 패로 너비우선탐색
        3. 도달 가능한 노드 수의 합이 n-1이면 시작 노드의 순위를 특정 가능
        */
        
        // 그래프 초기화
        ArrayList<Integer>[] winGraph = new ArrayList[n + 1];
        ArrayList<Integer>[] loseGraph = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }
        
        // 간선(대전) 정보 그래프에 정보
        for (int[] result : results) {
            winGraph[result[0]].add(result[1]);
            loseGraph[result[1]].add(result[0]);
        }
        
        int answer = 0;
        for (int i = 1; i <= n ; i++) {
            if (bfs(n, winGraph, i) + bfs(n, loseGraph, i) == n - 1) {
                answer++;
            }
        }
        return answer;
    }
    
    public int bfs(int n, ArrayList<Integer>[] graph, int player) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();
        
        visited[player] = true;
        que.add(player);
        
        int cnt = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.add(next);
                    cnt++;
                }
            }
        }
        
        // 시작 노드를 제외한 방문한 노드의 개수
        return cnt;
    }
}