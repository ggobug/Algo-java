import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X;   // 학생 수, 질문 횟수, 등수를 알고 싶은 학생
    static ArrayList<Integer>[] high;
    static ArrayList<Integer>[] low;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 각 배열 초기화
        high = new ArrayList[N + 1];
        low = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            high[i] = new ArrayList<>();
            low[i] = new ArrayList<>();
        }

        // 질문 결과 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a학생이 b학생보다 점수가 더 높다.
            high[a].add(b);
            low[b].add(a);
        }

        int minRank = N - bfs(high);
        int maxRank = bfs(low) + 1;
        System.out.println(maxRank + " " + minRank);
    }

    // 학생 X와 점수 우위 판별이 가능한 학생들의 수를 구하기 위한 bfs 탐색
    static int bfs(ArrayList<Integer>[] graph) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> que = new LinkedList<>();

        que.add(X);
        visited[X] = true;

        int count = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : graph[cur]) {
                if (visited[next]) continue;
                que.add(next);
                visited[next] = true;
                count++;
            }
        }
        return count;
    }
}
