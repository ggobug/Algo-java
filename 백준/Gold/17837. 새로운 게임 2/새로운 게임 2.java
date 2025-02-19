// 새로운 게임 2
// https://www.acmicpc.net/problem/17837

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[][] color; // 체스판 색상 정보 (0: 흰색, 1: 빨간색, 2: 파란색)
    static ArrayList<Integer>[][] board; // 체스판 위의 말들의 스택
    static Piece[] pieces; // 말들의 위치와 방향 정보

    // 이동 방향 (→, ←, ↑, ↓)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Piece {
        int x, y, dir;

        Piece(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 체스판 색깔 정보 저장
        color = new int[N][N];
        board = new ArrayList[N][N];
        pieces = new Piece[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = new ArrayList<>();
            }
        }

        // 말 정보 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            pieces[i] = new Piece(x, y, dir);
            board[x][y].add(i);
        }

        int turn = 0;
        while (turn++ < 1000) { // 1000턴 초과 시 종료 조건
            for (int i = 0; i < K; i++) {
                if (move(i)) { // 말 이동 후 4개 이상 쌓이면 종료
                    System.out.println(turn);
                    return;
                }
            }
        }

        System.out.println(-1); // 1000턴 초과 시 종료되지 않으면 -1 출력
    }

    // 말 이동 함수 (이동 성공 시 4개 이상 쌓이면 true 반환)
    static boolean move(int idx) {
        Piece piece = pieces[idx];
        int x = piece.x;
        int y = piece.y;
        int dir = piece.dir;

        // 현재 위치에서 해당 말 위에 있는 모든 말 찾기
        List<Integer> stack = new ArrayList<>();
        int index = board[x][y].indexOf(idx);
        for (int i = index; i < board[x][y].size(); i++) {
            stack.add(board[x][y].get(i));
        }

        // 기존 위치에서 이동할 말들 제거
        board[x][y] = new ArrayList<>(board[x][y].subList(0, index));

        // 다음 이동 위치 계산
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // 이동할 위치가 범위를 벗어나거나 파란색이면 방향 전환
        if (!isInBound(nx, ny) || color[nx][ny] == 2) {
            piece.dir ^= 1; // 방향 반대로 변경
            nx = x + dx[piece.dir];
            ny = y + dy[piece.dir];

            // 방향을 바꿨음에도 파란색이면 이동하지 않음
            if (!isInBound(nx, ny) || color[nx][ny] == 2) {
                board[x][y].addAll(stack); // 이동 취소 → 기존 위치로 돌려놓기
                return false;
            }
        }

        // 흰색 → 그냥 이동
        if (color[nx][ny] == 0) {
            board[nx][ny].addAll(stack);
        }
        // 빨간색 → 순서 반대로 이동
        else if (color[nx][ny] == 1) {
            Collections.reverse(stack);
            board[nx][ny].addAll(stack);
        }

        // 말 위치 갱신
        for (int num : stack) {
            pieces[num].x = nx;
            pieces[num].y = ny;
        }

        // 4개 이상 쌓였으면 게임 종료
        return board[nx][ny].size() >= 4;
    }

    // 체스판 범위 체크
    static boolean isInBound(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
