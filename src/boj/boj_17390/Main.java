package boj.boj_17390;

import javax.swing.plaf.ButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int Q;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 비내림차순 정렬
        Arrays.sort(arr);

        // 누적합
        for (int i = 1; i < N; i++) {
            arr[i] += arr[i - 1];
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()) - 1;
            int R = Integer.parseInt(st.nextToken()) - 1;

            if (L != 0) {
                System.out.println(arr[R] - arr[L - 1]);
            } else {
                System.out.println(arr[R]);
            }
        }
    }
}
