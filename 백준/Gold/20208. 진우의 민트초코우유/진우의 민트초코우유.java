// 진우의 민트초코우유
// https://www.acmicpc.net/problem/20208

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;             // 마을 크기, 초기 체력, 체력 회복량
    static int[][] village;         // 마을
    static ArrayList<int[]> milks;  // 민초 좌표
    static int[] home = new int[2]; // 진우 집
    static int maxMilk = 0;         // 민초 최대 개수

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // 민초마을 배열 초기화 및 입력 받기
        village = new int[N][N];
        milks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                village[i][j] = Integer.parseInt(st.nextToken());
                if (village[i][j] == 1) {
                    home[0] = i;
                    home[1] = j;
                } else if (village[i][j] == 2) {
                    milks.add(new int[]{i, j});
                }
            }
        }

        // 체력 == 이동할 수 있는 거리
        boolean[] visited = new boolean[milks.size()];
        dfs(home[0], home[1], M, 0, visited);

        System.out.println(maxMilk);


    }
    
    static void dfs(int x, int y, int hp, int milkCount, boolean[] visited) {
        // 집에 도착 시 민초 최대 개수 갱신
        if (distance(x, y, home[0], home[1]) <= hp) {
            maxMilk = Math.max(maxMilk, milkCount);
        }
        
        for (int i = 0; i < milks.size(); i++) {
            if (!visited[i]) {
                int milkX = milks.get(i)[0];
                int milkY = milks.get(i)[1];
                int dist = distance(x, y, milkX, milkY);

                if (dist <= hp) {
                    visited[i] = true;
                    dfs(milkX, milkY, hp - dist + H, milkCount + 1, visited); // 체력 회복하고 이동
                    visited[i] = false;
                }
            }
        }
    }

    static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
