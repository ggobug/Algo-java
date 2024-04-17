package boj_19951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H;
    static int[] arr;
    static int[] accum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        accum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // a번 칸부터 b번 칸까지 높이 k만큼 흙을 덮거나 파내라고 지시
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken());

            accum[a] += k;
            accum[b + 1] -= k;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            accum[i] += accum[i - 1];
            arr[i-1] += accum[i-1];
            sb.append(arr[i-1]).append(" ");
        }

        System.out.println(sb);
    }
}
