import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 보드판 저장
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < board.length - 7; i++) {
            for (int j = 0; j < board[0].length - 7; j++) {
                minCount = Math.min(minCount, getPainting(board, i, j));
            }
        }
        System.out.println(minCount);
    }

    // 칠해야 하는 사각형 개수
    static int getPainting(char[][] board, int x, int y) {
        if (x + 8 > board.length || y + 8 > board[0].length) {
            return Integer.MAX_VALUE;
        }

        int minCount;

        int countW = 0;
        int countB = 0;
        int res = (x + y) % 2;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                int tmp = (i + j) % 2;
                if (tmp == res) {
                    if (board[i][j] == 'W') {
                        countB++;
                    } else {
                        countW++;
                    }
                } else {
                    if (board[i][j] == 'W') {
                        countW++;
                    } else {
                        countB++;
                    }
                }
            }
        }
        minCount = Math.min(countB, countW);
        return minCount;
    }

}
