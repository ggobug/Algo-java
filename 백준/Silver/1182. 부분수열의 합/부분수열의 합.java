import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] seq;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 정수 개수
        S = Integer.parseInt(st.nextToken());   // 목표 합

        // 수열 입력 받기
        seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);

        // 목표 합이 0일 경우 공집합을 제외
        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    static void backtrack(int idx, int sum) {
        // 모든 원소를 탐색한 경우
        if (idx == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        // 현재 원소를 선택하는 경우
        backtrack(idx + 1, sum + seq[idx]);

        // 현재 원소를 선택하지 않는 경우
        backtrack(idx + 1, sum);
    }
}
