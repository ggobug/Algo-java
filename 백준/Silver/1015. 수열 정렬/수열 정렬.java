// 수열 정렬
// https://www.acmicpc.net/problem/1015

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
        int[] arr = new int[N];
        int[] brr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            brr[i] = arr[i];
        }

        // 오름차순 정렬
        Arrays.sort(brr);

        // 해당 값 찾기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            // brr에서 arr[i]가 몇번째인지 체크
            for (int j = 0; j < brr.length; j++) {
                if (brr[j] == arr[i]) {
                    sb.append(j).append(" ");
                    // 다음에 중복값이 될 수 없도록 값 변경
                    brr[j] = -1;
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
