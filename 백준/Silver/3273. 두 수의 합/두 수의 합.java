import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        //1. 수열 오름차순 정렬
        Arrays.sort(seq);

        //2. 쌍 찾기
        int pairCount = 0;  // 쌍의 개수
        for (int i = 0; i < seq.length; i++) {
            int target = x - seq[i];
            if (seq[i] >= target) break;

            // 2-1. 수열에서 target 탐색
            int left = 0;
            int right = seq.length - 1;
            int mid = -1;

            while (left <= right) {
                mid = (left + right) / 2;
                if (seq[mid] == target) {       // 목표값 찾으면 탐색 종료
                    pairCount++;
                    break;
                } else if (seq[mid] > target) {    // 목표값보다 크면 왼쪽 탐색
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        System.out.println(pairCount);
    }
}
