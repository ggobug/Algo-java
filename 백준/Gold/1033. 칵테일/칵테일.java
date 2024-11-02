import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;                   // 재료 개수
    static List<int[]>[] adj;       // 인접 리스트 (a, b, p, q 저장)
    static long[][] ratio;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 그래프 초기화
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 비율 입력받기
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b, p, q});
            adj[b].add(new int[]{a, q, p});
        }

        // 분자, 분모 배열 초기화
        ratio = new long[N][2];
        visited = new boolean[N];

        // 초기값 설정
        ratio[0][0] = 1;
        ratio[0][1] = 1;
        visited[0] = true;

        // dfs로 각 재료의 비율 계산
        dfs(0);

        // 모든 재료의 분모의 최소 공배수를 구함
        long lcm = ratio[0][1];
        for (int i = 1; i < N; i++) {
            lcm = lcm(lcm, ratio[i][1]);
        }

        // 최소 공배수를 이용하여 최종 질량 계산
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long scale = lcm / ratio[i][1];
            sb.append(ratio[i][0] * scale).append(" ");
        }
        System.out.println(sb);
    }

    // dfs : 각 재료의 비율 계산
    private static void dfs(int cur) {
        // 현 재료의 비율쌍 순회
        for (int[] next : adj[cur]) {
            int neighbor = next[0];
            int p = next[1];
            int q = next[2];

            // 방문한 재료면 패스
            if (visited[neighbor]) continue;

            // 미방문 재료인 경우
            visited[neighbor] = true;
            ratio[neighbor][0] = ratio[cur][0] * q;
            ratio[neighbor][1] = ratio[cur][1] * p;

            // 최대 공약수로 나누기
            long gcd = gcd(ratio[neighbor][0], ratio[neighbor][1]);
            ratio[neighbor][0] /= gcd;
            ratio[neighbor][1] /= gcd;

            dfs(neighbor);
        }
    }

    // 최소 공배수 계산
    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    // 최대 공약수 계산
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
