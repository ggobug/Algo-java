package boj_22862;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int s = 0;
        int e = 0;
        int count = 0;
        while (s < N && e < N) {

            if (count < K) {
                if (seq[e] % 2 != 0) {
                    count++;
                }
                e++;
                ans = Math.max(ans, e - s - count);
                continue;
            }

            if (seq[e] % 2 == 0) {
                e++;
                ans = Math.max(ans, e - s - count);
                continue;
            }

            if (seq[s] % 2 != 0) {
                count--;
            }
            s++;
            ans = Math.max(ans, e - s - count);
        }
        System.out.println(ans);
    }
}
