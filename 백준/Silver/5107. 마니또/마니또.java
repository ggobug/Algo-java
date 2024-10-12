// 마니또
// https://www.acmicpc.net/problem/5107

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 각 테스트 케이스 번호를 저장할 변수
    static int tcNumber = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());    // 사람 수
            if (N == 0) break;

            Map<String, Integer> nameToIndex = new HashMap<>();
            String[] indexToName = new String[N];

            int idx = 0;
            int[] graph = new int[N];
            boolean[] visited = new boolean[N];
            boolean[] finished = new boolean[N]; // 사이클 여부 체크
            int cycleCount = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();

                // 이름을 인덱스로 변환하여 저장
                if (!nameToIndex.containsKey(from)) {
                    nameToIndex.put(from, idx);
                    indexToName[idx] = from;
                    idx++;
                }
                if (!nameToIndex.containsKey(to)) {
                    nameToIndex.put(to, idx);
                    indexToName[idx] = to;
                    idx++;
                }

                // from이 to를 가리키는 것을 그래프로 표현
                graph[nameToIndex.get(from)] = nameToIndex.get(to);
            }

            // 사이클 개수 구하기
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    cycleCount += dfs(i, graph, visited, finished);
                }
            }

            sb.append(tcNumber++).append(" ").append(cycleCount).append("\n");
        }
        System.out.println(sb);
        
    }

    // 사이클 개수 구하는 메서드
    static int dfs(int cur, int[] graph, boolean[] visited, boolean[] finished) {
        visited[cur] = true;
        int next = graph[cur];

        // 아직 방문하지 않은 노드라면 계속 탐색
        if (!visited[next]) {
            if (dfs(next, graph, visited, finished) == 1) {
                return 1;
            }
        } else if (!finished[next]) {
            return 1;
        }

        finished[cur] = true;
        return 0;
    }

}
