import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        // 수열 오름차순으로 정렬
        Arrays.sort(seq);

        // 쌍 찾기
        int answer = 0; // 조건을 만족하는 쌍의 개수
        for (int i = 0; i < seq.length; i++) {
            int target = x - seq[i];
            if (target <= seq[i]) continue;
            if (findPair(seq, target)) answer++;
        }
        System.out.println(answer);
    }

    // 투포인터 알고리즘을 이용한 쌍 찾기
    static boolean findPair(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            // 목표값 발견
            if (arr[mid] == target) return true;

            // 목표값보다 큰 경우 : 왼쪽 탐색
            if (arr[mid] > target) r = mid - 1;

            // 목표값보다 작은 경우 : 오른쪽 탐색
            else l = mid + 1;
        }
        return false;
    }
}