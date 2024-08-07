import java.util.*;

class Solution {
    public int solution(String[] maps) {
        
        // 출발 - 레버 - 도착 : 최단 경로(시간) 구하기
        // 출발 - 레버 최단 시간
        
        int answer = findOptimalTime(maps);
        return answer;
    }
    
    // 최단 시간 구하는 메서드
    static int findOptimalTime(String[] maps) {
        // 출발, 레버, 도착지 찾기
        int[] start = new int[2], laber = new int[2], exit = new int[2];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (c == 'L') {
                    laber[0] = i;
                    laber[1] = j;
                } else if (c == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        int a = bfs(start, laber, maps);
        int b = bfs(laber, exit, maps);
        if (a == -1 || b == -1) return -1;
        return a + b;
    }
    
    // 출발 - 도착 : 최단 시간 반환
    static int bfs(int[] start, int[] goal, String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[][] visited = new int[n][m];
        visited[start[0]][start[1]] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            // 목표지점인가?
            if (maps[cur[0]].charAt(cur[1]) == maps[goal[0]].charAt(goal[1])) {
                return visited[goal[0]][goal[1]] - 1;
            }
                     
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] != 0) continue;
                if (maps[nx].charAt(ny) == 'X') continue;
                
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                queue.add(new int[]{nx, ny});
            }
        }
        return -1;
        
    }
}