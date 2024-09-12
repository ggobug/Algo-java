class Solution {
    public int solution(int[][] board, int[][] skill) {
        // 내구도가 0이하가 되면 파괴됨
        int n = board.length;
        int m = board[0].length;
        
        // 누적합을 위한 배열 선언
        int[][] diff = new int[n + 1][m + 1];

        // 쿼리 적용 (경계값만 수정)
        for (int[] query : skill) {
            int degree = query[0] == 1 ? -query[5] : query[5];
            
            int r1 = query[1], c1 = query[2], r2 = query[3], c2 = query[4];
            diff[r1][c1] += degree;
            diff[r1][c2 + 1] -= degree;
            diff[r2 + 1][c1] -= degree;
            diff[r2 + 1][c2 + 1] += degree;
        }

        // 누적합 적용 (행 기준)
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        // 누적합 적용 (열 기준)
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        // 결과 반영 및 파괴되지 않은 건물 수 세기
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += diff[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}