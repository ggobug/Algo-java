import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;   // 게임 구역의 크기
    static int[][] graph;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 게임 구역 입력 받기
        StringTokenizer st;
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];

        dfs(0, 0);
        if (visited[N - 1][N - 1]) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    private static boolean dfs(int r, int c) {
        // 승리 지점에 도달하면 종료
        visited[r][c] = true;
        if (r == N - 1 && c == N - 1) return true;

        // 오른쪽이나 아래칸으로 이동
        int num = graph[r][c];
        for (int d = 0; d < 2; d++) {
            int nr = r + dx[d] * num;
            int nc = c + dy[d] * num;

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
        return false;
    }
}
