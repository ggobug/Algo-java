import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());    // 집합 S의 크기
        int[] S = new int[L + 2];
        S[0] = 0;
        S[L + 1] = 1001;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬
        Arrays.sort(S);

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = -1;
        int e = -1;
        for (int i = 1; i < L + 2; i++) {
            // n이 집합에 포함되면 좋은 구간은 0개
            if (S[i] == n) {
                System.out.println(0);
                return;
            }

            // n이 포함되는 구간 찾기
            if (n > S[i - 1] && n < S[i]) {
                s = S[i - 1] + 1;
                e = S[i] - 1;
                break;
            }
        }

        // n이 포함되는 구간의 개수 구하기
        int answer = 0;
        for (int i = s; i < e; i++) {
            for (int j = i + 1; j <= e; j++) {
                if (n >= i && n <= j) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
