class Solution {
    public int solution(String[][] board, int h, int w) {
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        String color = board[h][w];
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int nx = h + dx[d];
            int ny = w + dy[d];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                if (board[nx][ny].equals(color)) cnt++;
            }
        }
        return cnt;
    }
}