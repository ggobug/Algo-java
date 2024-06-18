import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 센서의 개수
        int K = Integer.parseInt(br.readLine());    // 집중국의 개수

        int[] sensors = new int[N]; // 모든 센서의 좌표

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        // 센서 좌표 정렬
        Arrays.sort(sensors);

        // 센서간 거리
        Integer[] distances = new Integer[N - 1];
        for (int i = 1; i < N; i++) {
            distances[i - 1] = sensors[i] - sensors[i - 1];
        }

        // 거리 정렬
        Arrays.sort(distances, Collections.reverseOrder());

        int minLengthSum  = 0;
        for (int i = K - 1; i < distances.length; i++) {
            minLengthSum += distances[i];
        }
        System.out.println(minLengthSum);
    }
}
