import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, N;
    static char[][] cave;
    static int[] throwsHeight;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cave = new char[R][C];

        // 동굴 입력 받기
        for (int r = 0; r < R; r++) {
            cave[r] = br.readLine().toCharArray();
        }

        // 던질 횟수 입력
        N = Integer.parseInt(br.readLine());
        throwsHeight = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            throwsHeight[i] = Integer.parseInt(st.nextToken());
        }

        // 막대 던지기
        for (int i = 0; i < N; i++) {
            throwStick(i % 2 == 0, throwsHeight[i]);
            processCluster();
        }

        // 결과 출력
        printCave();
    }

    // 막대 던지기
    static void throwStick(boolean fromLeft, int height) {
        int row = R - height;

        if (fromLeft) { // 왼쪽에서 던짐
            for (int col = 0; col < C; col++) {
                if (cave[row][col] == 'x') {
                    cave[row][col] = '.';
                    return;
                }
            }
        } else { // 오른쪽에서 던짐
            for (int col = C - 1; col >= 0; col--) {
                if (cave[row][col] == 'x') {
                    cave[row][col] = '.';
                    return;
                }
            }
        }
    }

    // 클러스터 검사 및 이동 처리
    static void processCluster() {
        boolean[][] visited = new boolean[R][C];
        Set<int[]> floatingClusters = new HashSet<>();

        // 바닥과 연결된 미네랄 탐색 (BFS)
        for (int col = 0; col < C; col++) {
            if (cave[R - 1][col] == 'x' && !visited[R - 1][col]) {
                bfs(R - 1, col, visited);
            }
        }

        // 떠있는 클러스터 찾기
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (cave[r][c] == 'x' && !visited[r][c]) {
                    floatingClusters.add(new int[]{r, c});
                }
            }
        }

        if (!floatingClusters.isEmpty()) {
            dropCluster(floatingClusters);
        }
    }

    // BFS로 연결된 클러스터 확인
    static void bfs(int r, int c, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && cave[nx][ny] == 'x' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    // 떠 있는 클러스터 떨어뜨리기
    static void dropCluster(Set<int[]> floatingClusters) {
        List<int[]> clusterList = new ArrayList<>(floatingClusters);
        clusterList.sort(Comparator.comparingInt(a -> -a[0])); // 행이 큰(아래쪽) 것부터 정렬

        // 클러스터 제거
        for (int[] cell : clusterList) {
            cave[cell[0]][cell[1]] = '.';
        }

        // 최소 낙하 거리 계산
        int dropDistance = R;
        for (int[] cell : clusterList) {
            int r = cell[0], c = cell[1];
            int dist = 0;

            for (int nr = r + 1; nr < R; nr++) {
                if (cave[nr][c] == 'x') break;
                dist++;
            }
            dropDistance = Math.min(dropDistance, dist);
        }

        // 클러스터 떨어뜨리기
        for (int[] cell : clusterList) {
            cave[cell[0] + dropDistance][cell[1]] = 'x';
        }
    }

    // 동굴 출력
    static void printCave() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : cave) {
            sb.append(row).append("\n");
        }
        System.out.print(sb);
    }
}