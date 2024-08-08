import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] visited = new int[1_000_001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        int answer = bfs(x, y, n, visited);
        if (answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
    
    static int bfs(int x, int y, int n, int[] visited) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);       
        visited[x] = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            if (cur+n <= 1000000 && visited[cur+n] == Integer.MAX_VALUE) {
                visited[cur+n] = visited[cur] + 1;
                que.add(cur+n);
            } 
            if (cur*2 <= 1000000 && visited[cur*2] == Integer.MAX_VALUE) {
                visited[cur*2] = visited[cur] + 1;
                que.add(cur*2);
            }
            if (cur*3 <= 1000000 && visited[cur*3] == Integer.MAX_VALUE){
                visited[cur*3] = visited[cur] + 1;
                que.add(cur*3);
            }
        }
        return visited[y];
    }
}