import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static int K;
    static int result = -1;
    static int[] tmp; // tmp 배열을 전역으로 선언하여 재사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // A 배열의 크기
        K = Integer.parseInt(st.nextToken());

        // 배열 입력 받기
        int[] arrayA = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrayA[i] = Integer.parseInt(st.nextToken());
        }

        // 임시 배열 초기화
        tmp = new int[N];
        mergeSort(arrayA, 0, N - 1);

        System.out.println(result);
    }

    // 병합 정렬 함수(오름차순 정렬)
    static void mergeSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);       // 전반부 정렬
            mergeSort(arr, q + 1, r);   // 후반부 정렬
            merge(arr, p, q, r);        // 병합
        }
    }

    // 병합 함수
    static void merge(int[] arr, int p, int q, int r) {
        int i = p, j = q + 1, t = p;

        // 두 부분 배열을 병합
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        // 남은 요소 처리
        while (i <= q) {
            tmp[t++] = arr[i++];
        }
        while (j <= r) {
            tmp[t++] = arr[j++];
        }

        // 병합 결과를 원래 배열에 저장
        for (i = p; i <= r; i++) {
            arr[i] = tmp[i];
            count++;
            if (count == K) { // K번째 저장이면 결과 저장
                result = arr[i];
                return; // 결과를 찾으면 조기 종료
            }
        }
    }
}
