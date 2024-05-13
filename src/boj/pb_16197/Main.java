//package boj.pb_16197;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//// 버튼 누르면 두 동전 이동
//// 벽에 막히면 이동 X
//// 위치 중복 가능
//// 한 동전만 보드에서 떨어뜨리기 위해 눌러야 하는 최소 횟수
//public class Main {
//
//    // BFS
//
//    static int N, M;
//    static char[][] board;
//    static int[] first, second;
//    //                오른 아래 왼 위
//    static int[] dx = {0, 1, 0, -1};
//    static int[] dy = {1, 0, -1, 0};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        board = new char[N][M];
//
//        int[] first = new int[2];
//        int[] second = new int[2];
//        Arrays.fill(first, -1);
//        Arrays.fill(second, -1);
//
//        for (int i = 0; i < N; i++) {
//            String line = br.readLine();
//            for (int j = 0; j < M; j++) {
//                board[i][j] = line.charAt(j);
//                if (board[i][j] == 'o') {
//                    if (Arrays.equals(first, new int[]{-1, -1})) {
//                        second[0] = i;
//                        second[1] = j;
//                    } else {
//                        first[0] = i;
//                        first[1] = j;
//                    }
//                }
//            }
//        }
//
//        int ans = bfs(first, second);
//        if (ans > 10) {
//            System.out.println(-1);
//        } else {
//            System.out.println(ans);
//        }
//
//    }
//
//    // 이동 가능한지 체크
//    static boolean isInRange(int x, int y) {
//        return x >= 0 && x < N && y >= 0 && y < M;
//    }
//
//    // 커맨드 이동
//    static int moveCoin(int[] coin1, int[] coin2, int cmd) {
//        boolean firstDrop = false;
//        boolean secondDrop = false;
//
//        int[] newFirst = new int[]{coin1[0] + dx[cmd], coin1[1] + dy[cmd]} ;
//        int[] newSecond = new int[]{coin2[0] + dx[cmd], coin2[1] + dy[cmd]};
//
//        // 첫번째 동전
//        if (isInRange(newFirst[0], newFirst[1])) {
//            // 벽
//            if (board[newFirst[0]][newFirst[1]] == '#') {
//                newFirst[0] = coin1[0];
//                newFirst[1] = coin1[1];
//            }
//        } else {
//            firstDrop = true;
//        }
//
//        // 두번째 동전
//        if (isInRange(newSecond[0], newSecond[1])) {
//            if (board[newSecond[0]][newSecond[1]] == '#') {
//                newSecond[0] = coin2[0];
//                newSecond[1] = coin2[1];
//            }
//        } else {
//            secondDrop = true;
//        }
//
//        if (firstDrop && secondDrop) {
//            return 0;
//        } else if (firstDrop || secondDrop) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }
//
//    // bfs 한 동전만 보드에서 떨어지는 최소 횟수 찾기
//    static int bfs() {
//        Queue<int[]> que = new LinkedList<>();
//        Set<String> visited = new HashSet<>();
//
//        // 초기값
//        que.add(new int[]{first[0], first[1], second[0], second[1]});
//        visited.add(first[0] + "" + first[1] + "" + second[0] + "" + second[1]);
//        visited.add(second[0] + "" + second[1] + "" + first[0] + "" + first[1]);
//
//        int[] coin1 = new int[2], coin2 = new int[2];
//        int count = 0;
//
//        while (!que.isEmpty()) {
//            int[] cur = que.poll();
//            coin1[0] = cur[0];
//            coin1[1] = cur[1];
//            coin2[0] = cur[2];
//            coin2[1] = cur[3];
//
//            count++;
//
//            int flag;
//            for (int i = 0; i < 4; i++) {
//                flag = moveCoin(coin1, coin2, i);
//                if (flag == 0) {
//                    continue;
//                } else if (flag == 1) {
//                    System.out.println();
//                    System.exit(0);
//                } else {
//
//                }
//            }
//        }
//    }
//
//}
