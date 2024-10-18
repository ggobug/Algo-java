// 모자이크
// https://www.acmicpc.net/problem/2539
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 행의 개수
        int M = Integer.parseInt(st.nextToken());   // 열의 개수

        int K = Integer.parseInt(br.readLine());    // 사용할 색종이의 장 수
        int L = Integer.parseInt(br.readLine());    // 잘못 칠해진 칸의 수

        int[] changes = new int[L];
        int maxRow = 0;
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            changes[i] = y;
            maxRow = Math.max(maxRow, x);
        }

        // 열 크기 기준 오름차순으로 정렬
        Arrays.sort(changes);

        int left = maxRow;
        int right = M;
        int answer = M;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1;

            // 색종이 앞에서부터 붙이기
            int s = changes[0]; // 색종이의 시작점
            int e = changes[0]; // 잘못된 칸의 위치
            for (int i = 1; i < L; i++) {
                // 잘못된 칸 갱신
                e = changes[i];

                // 현재 붙인 색종이 안에 들어가는 경우
                if (e - s <= mid - 1) continue;

                // 들어가지 않는 경우
                cnt++;  // 새로운 색종이 붙이기
                s = changes[i]; // 색종이 시작점 갱신
            }

            // 사용한 색종이 수가 더 많을 경우
            if (cnt > K) {
                left = mid + 1;
            } else {    // 적을 경우
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        System.out.println(answer);

    }
}