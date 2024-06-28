import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        Map<Integer, Integer> oilGroup = new HashMap<>();   // 오일 덩어리 별 인덱싱, 오일 개수 저장
        int[][] group = new int[n][m];
        
        bfs(oilGroup, group, land);
        
        return findMaxOil(oilGroup, group, land);
    }
    
    // bfs
    public void bfs(Map<Integer, Integer> oilGroup, int[][] group, int[][] land) {
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};        
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 그룹핑 되지 않은 석유를 발견하면
                if (!visited[i][j] && land[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    group[i][j] = ++idx;
                    oilGroup.put(idx, 1);
                    
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];

                            // 방문하지 않은 곳이면
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && land[nx][ny] == 1) {
                                queue.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                                group[nx][ny] = idx;
                                oilGroup.put(idx, oilGroup.get(idx) + 1);
                            }
                        }
                    }
                }
            }
        }
    }
    
    // 시추관의 위치에 따라 얻을 수 있는 석유의 양
    public int findMaxOil(Map<Integer, Integer> oilGroup, int[][] group, int[][] land) {
        int maxOil = 0;
        // 각 열에 시추관을 설치했을 때, 시추할 수 있는 석유 덩어리 그룹과, 석유의 양 파악
        // 최대로 얻을 수 있는 석유의 양 구하기
        for (int c = 0; c < land[0].length; c++) {
            Set<Integer> groupSet = new HashSet<>();
            int tmpOil = 0;
            for (int r = 0; r < land.length; r++) {
                if (land[r][c] == 1 && !groupSet.contains(group[r][c])) {
                    groupSet.add(group[r][c]);
                    tmpOil += oilGroup.get(group[r][c]);
                }
            }
            maxOil = Math.max(maxOil, tmpOil);
        }
        return maxOil;
    }
}
