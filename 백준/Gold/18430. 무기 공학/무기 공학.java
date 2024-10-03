import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int maxSumIntensity = 0;
    static int N, M;            // 나무의 세로, 가로 길이
    static int[][] intensity;   // 나무 강도
    static boolean[][] used;    // 사용 정보
    static int[][][] boomerangs = {
            {{0, 0}, {0, -1}, {1, 0}},
            {{0, 0}, {0, -1}, {-1, 0}},
            {{0, 0}, {-1, 0}, {0, 1}},
            {{0, 0}, {1, 0}, {0, 1}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 부메랑 강도의 합의 최댓값 구하기

        // 나무 강도 입력 받기
        intensity = new int[N][M];
        used = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                intensity[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0, 0);
        System.out.println(maxSumIntensity);
    }

    // 백트래킹
    static void backtrack(int index, int curSumIntensity) {

        if (index == N * M) {
            // 마지막 칸까지 탐색했으면 최대값 갱신
            maxSumIntensity = Math.max(maxSumIntensity, curSumIntensity);
            return;
        }

        int r = index / M;
        int c = index % M;

        // 해당 칸이 이미 사용되었다면 다음 칸으로
        if (used[r][c]) {
            backtrack(index + 1, curSumIntensity);
            return;
        }

        // 4가지 부메랑 모양을 시도
        for (int[][] boomerang : boomerangs) {
            if (canMakeBoomerang(r, c, boomerang)) {
                int addedStrength = makeBoomerang(r, c, boomerang, true);
                backtrack(index + 1, curSumIntensity + addedStrength);
                makeBoomerang(r, c, boomerang, false);
            }
        }

        // 부메랑을 만들지 않고 다음으로 넘어가기
        backtrack(index + 1, curSumIntensity);
    }

    // 부메랑을 놓을 수 있는지 확인하는 함수
    static boolean canMakeBoomerang(int r, int c, int[][] boomerang) {
        for (int[] b : boomerang) {
            int nr = r + b[0];
            int nc = c + b[1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || used[nr][nc]) {
                return false;
            }
        }
        return true;
    }

    // 부메랑을 놓거나 되돌리는 함수
    static int makeBoomerang(int r, int c, int[][] boomerang, boolean place) {
        int totalStrength = 0;

        for (int i = 0; i < boomerang.length; i++) {
            int nr = r + boomerang[i][0];
            int nc = c + boomerang[i][1];
            used[nr][nc] = place;

            // 중심인 경우 강도를 2배로 계산
            if (i == 0) {
                totalStrength += intensity[nr][nc] * 2;
            } else {
                totalStrength += intensity[nr][nc];
            }
        }

        return totalStrength;
    }
}
