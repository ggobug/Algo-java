import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int N, X = 0, Y = 0;    // 참가자 수, 트랙의 길이, 속도 한계치
        int speed = 0;
        double winTime = Double.MAX_VALUE;

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] speeds = new int[N];
            for (int i = 0; i < N; i++) {
                speeds[i] = Integer.parseInt(st.nextToken());
            }

            // 당신의 자동차 속도
            int mySpeed = speeds[N - 1];

            // 다른 참가자의 최소 완료 시간
            double minTime = Double.MAX_VALUE;
            for (int i = 0; i < N - 1; i++) {
                minTime = Math.min(minTime, (double) X / speeds[i]);
            }

            // 부스터 없이도 우승 가능한지 체크
            if ((double) X / mySpeed < minTime) {
                sb.append(0).append("\n");
                continue;
            }

            // 단독 우승 가능한 경우
            int low = 0;
            int high = Y;
            int bestZ = -1;

            while (low <= high) {
                int mid = (low + high) / 2;
                double myTime = 1.0 + (double) (X - mid) / mySpeed; // 부스터 사용 시 시간 계산

                if (myTime < minTime) {
                    bestZ = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            sb.append(bestZ).append("\n");
        }

        System.out.println(sb);
    }
}
