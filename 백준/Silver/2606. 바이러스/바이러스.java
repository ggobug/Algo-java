import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine());    // 연결된 컴퓨터 쌍의 수

        boolean[][] graph = new boolean[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }

        boolean[] visited = new boolean[N + 1];

        dfs(graph, visited, 1);
        System.out.println(count);
    }

    static void dfs(boolean[][] graph, boolean[] visited, int node) {
        visited[node] = true;

        for (int i = 1; i < graph.length; i++) {
            if (graph[node][i] && !visited[i]) {
                count++;
                dfs(graph, visited, i);
            }
        }
    }
}
