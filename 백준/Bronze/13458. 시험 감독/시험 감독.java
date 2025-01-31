import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 시험장 개수
        int[] testCenters = new int[N];            // 각 시험장의 응시자 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            testCenters[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());    // 총감독관이 감시할 수 있는 응시자 수
        int C = Integer.parseInt(st.nextToken());    // 부감독관이 감시할 수 있는 응시자 수

        long total = 0;  // 배치해야할 감독관 수 (long으로 변경)
        for (int testCenter : testCenters) {
            // 총감독관 한 명 배치
            testCenter -= B;
            total++;
            if (testCenter <= 0) continue;

            // 부감독관 배치
            total += (testCenter + C - 1) / C; // 올림 연산 적용
        }
        System.out.println(total);
    }
}
