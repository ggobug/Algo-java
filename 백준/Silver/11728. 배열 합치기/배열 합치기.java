import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // A, B 배열 선언
        int[] arrA = new int[N];
        int[] arrB = new int[M];

        // A 배열 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        // B 배열 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        // 병합 정렬 방식으로 A, B 배열을 합치기
        int[] result = new int[N + M];
        int i = 0, j = 0, k = 0;

        // 두 배열을 병합
        while (i < N && j < M) {
            if (arrA[i] <= arrB[j]) {
                result[k++] = arrA[i++];
            } else {
                result[k++] = arrB[j++];
            }
        }

        // 남은 A 배열의 원소 처리
        while (i < N) {
            result[k++] = arrA[i++];
        }

        // 남은 B 배열의 원소 처리
        while (j < M) {
            result[k++] = arrB[j++];
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
