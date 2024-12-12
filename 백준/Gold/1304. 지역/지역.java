import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시(노드) 개수
        int M = Integer.parseInt(st.nextToken()); // 도로(간선) 개수
        int[] blocked = new int[N + 1]; // 특정 구간이 막혀 있는지 표시

        // 일반 도로 입력 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 시작 지점이 끝보다 작으면 무시 (단방향 조건)
            if (start < end) continue;

            // 막힌 구간 표시
            for (int j = end; j < start; j++) {
                blocked[j] = 1;
            }
        }

        // 가능한 지역 크기 계산
        for (int regionSize = 1; regionSize <= N; regionSize++) {
            // 도시 수가 나누어 떨어지지 않으면 해당 크기는 불가능
            if (N % regionSize != 0) continue;

            boolean isValid = true;

            // 각 구간이 유효한지 확인
            for (int city = regionSize; city <= N; city += regionSize) {
                if (blocked[city] == 1) {
                    isValid = false;
                    break;
                }
            }

            // 유효한 지역 크기 발견
            if (isValid) {
                System.out.println(N / regionSize);
                return;
            }
        }
    }
}