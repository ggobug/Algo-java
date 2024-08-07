class Solution {
    private static int maxVisit = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        // 최소 필요 피로도, 소모 피로도
        // k : 현재 피로도
        // 유저가 탐험할 수 있는 최대 던전 수 구하기
        
        boolean[] visited = new boolean[dungeons.length];
        
        // 완전 탐색
        dfs(k, dungeons, visited, 0);
        return maxVisit;
    }
    
    private static void dfs(int curFatigue, int[][] dungeons, boolean[] visited, int visitCnt) {
        maxVisit = Math.max(maxVisit, visitCnt);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && curFatigue >= dungeons[i][0]) {
                // 던전을 방문할 수 있는 경우
                visited[i] = true;
                dfs(curFatigue - dungeons[i][1], dungeons, visited, visitCnt + 1);
                visited[i] = false; // 다시 방문 여부를 되돌림
            }
        }
    }
}