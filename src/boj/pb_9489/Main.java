package boj.pb_9489;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k, ans;    // 노드의 수, 구해야 하는 노드 번호
    static int[] seq, par;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            if (n == 0 && k == 0) break;

            seq = new int[n + 1];
            par = new int[n + 1];
            int target_idx = 0;
            int depth = -1;
            seq[0] = -1;
            par[0] = -1;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                seq[i] = Integer.parseInt(st.nextToken());

                // 타겟 노드 번호 저장
                if (seq[i] == k) target_idx = i;

                // 깊이 저장
                if (seq[i] != seq[i - 1] + 1) depth++;
                par[i] = depth;
            }

            // 깊이가 같고 부모가 같지 않은 사촌 노드 개수 찾기
            ans = 0;
            for (int i = 1; i <= n; i++) {
                // 깊이가 같고
                if (par[i] != par[target_idx]) {
                    if (par[par[i]] == par[par[target_idx]]) {
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
