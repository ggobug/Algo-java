import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 과목의 수
        int M = Integer.parseInt(st.nextToken());   // 선수 조건의 수

        int[] indegree = new int[N + 1];    // 진입 차수
        List<Integer>[] graph = new List[N + 1];    // 인접리스트
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        // 선수과목 조건 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indegree[b]++;
        }

        int[] times = new int[N + 1];   // 최소 시간 저장
        Arrays.fill(times, 1);

        // 선수과목 없는 과목들 큐에 추가
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) if (indegree[i] == 0) que.add(i);

        // 위상정렬
        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : graph[cur]) {
                indegree[next]--;
                times[next] = Math.max(times[next], times[cur] + 1);

                if (indegree[next] == 0) que.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(times[i]).append(" ");
        }
        System.out.println(sb);
    }
}
