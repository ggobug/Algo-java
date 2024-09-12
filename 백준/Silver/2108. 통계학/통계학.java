import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] count = new int[8001];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            count[num + 4000]++;
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // 산술평균
        int arithmeticMean = (int) Math.round((double) sum / N);

        // 중앙값 및 최빈값 계산
        int median = Integer.MIN_VALUE;
        int mode = 0;
        int maxFrequency = 0;
        int modeCount = 0;
        boolean isSecondMode = false; // 두 번째로 작은 최빈값 선택 여부 확인

        int countSum = 0; // 누적 합을 이용해 중앙값 계산

        for (int i = 0; i < 8001; i++) {
            if (count[i] > 0) {
                // 중앙값 찾기
                countSum += count[i];
                if (countSum >= (N + 1) / 2 && median == Integer.MIN_VALUE) {
                    median = i - 4000;  // 중앙값은 누적합이 중간에 도달했을 때
                }

                // 최빈값 찾기
                if (count[i] > maxFrequency) {
                    maxFrequency = count[i];
                    mode = i - 4000;
                    isSecondMode = true;
                } else if (count[i] == maxFrequency && isSecondMode) {
                    mode = i - 4000;
                    isSecondMode = false;  // 두 번째로 작은 최빈값 저장 후 더 이상 갱신 안 함
                }
            }
        }

        // 범위 계산
        int range = max - min;

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(arithmeticMean).append("\n");
        sb.append(median).append("\n");
        sb.append(mode).append("\n");
        sb.append(range).append("\n");

        System.out.print(sb);
    }
}
