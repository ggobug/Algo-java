package boj.boj_10713;

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

        st = new StringTokenizer(br.readLine());

        int[] tours = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            tours[i] = Integer.parseInt(st.nextToken());
        }

        int[] a = new int[N + 1]; // 티켓 구입 가격
        int[] b = new int[N + 1]; // 카드 사용시 통과 가격
        int[] c = new int[N + 1]; // 카드 구매 가격

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        // 도시별 방문 횟수 체크
        int[] visitCount = new int[N + 1];
        for (int i = 1; i < M; i++) {
            int from = tours[i];
            int to = tours[i + 1];

            if (from > to) {
                int tmp = from;
                from = to;
                to = tmp;
            }

            visitCount[from]++;
            visitCount[to]++;
        }

        long ans = 0;
        long tmp = 0;
        for (int i = 1; i < N; i++) {
            tmp += visitCount[i];
            ans += Math.min(tmp * a[i], tmp * b[i] + c[i]);
        }
        System.out.println(ans);
    }
}
