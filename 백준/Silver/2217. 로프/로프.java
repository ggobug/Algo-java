import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N;
    static Integer[] maxWeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maxWeight = new Integer[N];

        for (int i = 0; i < N; i++) maxWeight[i] = Integer.parseInt(br.readLine());

        // 내림차순 정렬
        Arrays.sort(maxWeight, Collections.reverseOrder());

        // 개수 늘리며 최대 중량 갱신
        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, maxWeight[i] * (i + 1));
        }
        System.out.println(answer);
    }
}
