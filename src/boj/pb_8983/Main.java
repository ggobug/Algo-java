package boj.pb_8983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M, N, L; // 사대의 수, 동물의 수, 사정거리
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 사정 거리 밖
            if (b > L) continue;

            int left = 0;
            int right = M - 1;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] < a) left = mid + 1;
                else right = mid - 1;
            }

            if (left < M && Math.abs(arr[left] - a) + b <= L) count++;
            else if (right >= 0 && Math.abs(arr[right] - a) + b <= L) count++;
        }
        System.out.println(count);
    }
}
