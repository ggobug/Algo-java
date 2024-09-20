import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs;

        board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        solveSudoku();
        printBoard();
    }

    // 들어갈 수 있는 수의 집합 구하기
    static Set<Integer> findCandidate(int r, int c) {
        // 후보 집합 초기화
        Set<Integer> candidateSet = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            candidateSet.add(i);
        }

        // 열 체크
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == 0) continue;
            candidateSet.remove(board[i][c]);
        }

        // 행 체크
        for (int num : board[r]) {
            if (num == 0) continue;
            candidateSet.remove(num);
        }

        // 3x3 박스 체크
        int shareR = (r / 3) * 3;
        int shareC = (c / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nr = shareR + i;
                int nc = shareC + j;
                if (nr == r && nc == c) continue;
                if (board[nr][nc] == 0) continue;
                candidateSet.remove(board[nr][nc]);
            }
        }

        return candidateSet;
    }

    static boolean solveSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) { // 빈 칸 찾기
                    Set<Integer> candidates = findCandidate(i, j);
                    for (int num : candidates) {
                        board[i][j] = num; // 후보 숫자 넣기
                        if (solveSudoku()) { // 재귀 호출
                            return true; // 성공적으로 완료된 경우
                        }
                        board[i][j] = 0; // 실패 시 백트래킹
                    }
                    return false; // 가능한 숫자가 없는 경우
                }
            }
        }
        return true; // 모든 칸이 채워졌으면 true 반환
    }

    // 스도쿠 보드 출력
    static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
