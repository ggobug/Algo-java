import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer>[] graph;   // 인접 리스트로 그래프 표현
    static boolean[] visited;       // 방문 여부
    static int N;                   // 도시 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N == 1) { // 도시가 1개라면 수정 필요 없음
            System.out.println(0);
            return;
        }

        // 1. 인접 리스트로 그래프 생성
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        int cnt = 0; // 전체 도로 수
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'Y') {
                    graph[i].add(j);
                    cnt++;
                }
            }
        }
        cnt /= 2;

        // 2. 연결 요소 탐색
        visited = new boolean[N];
        List<Integer> components = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 방문하지 않은 노드에서 DFS 시작
                visited[i] = true;
                components.add(dfs(i));
            }
        }

        // 3. 연결 요소 크기와 도로 수 계산
        int sum = 0; // 각 연결 요소 내부에서 필요한 도로 수
        for (int size : components) {
            sum += size - 1; // 각 연결 요소에 필요한 도로 수
            if (size == 1) { // 크기가 1인 요소는 연결 불가
                System.out.println(-1);
                return;
            }
        }

        // 4. 최소 도로 수정 계산
        if (components.size() - 1 <= cnt - sum) {
            System.out.println(components.size() - 1); // 필요한 도로 수 출력
        } else {
            System.out.println(-1); // 도로 부족으로 연결 불가
        }
    }

    // DFS 함수: 연결 요소 크기 계산
    static int dfs(int now) {
        int ret = 1; // 현재 노드 포함
        for (int next : graph[now]) { // 인접 노드 탐색
            if (visited[next]) continue;
            visited[next] = true; // 방문 표시
            ret += dfs(next); // 연결된 노드 수 누적
        }
        return ret;
    }
}
