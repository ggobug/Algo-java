import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());   // 소유한 랜선의 개수
        int N = Integer.parseInt(st.nextToken());   // 필요한 랜선의 개수

        long[] lines = new long[K];

        // 소유한 랜선 입력 받기
        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }

        // 길이 기준 오름차순 정렬
        Arrays.sort(lines);

        // 매개변수 탐색
        long left = 1;
        long right = lines[K - 1];
        long answer = -1;
        while (left <= right) {
            long mid = (left + right) / 2;

            // N개 이상 만들 수 있는지 체크
            long count = 0;
            for (long line : lines) {
                count += line / mid;
            }

            if (count >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);

    }
}
