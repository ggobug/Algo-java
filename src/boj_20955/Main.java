package boj_20955;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int N; // 뉴런의 개수 (노드)
    static int M; // 시냅스의 개수 (간선)
    static int[] par;

    // find
    static int find(int x) {

        if (par[x] == x) {
            return x;
        }

        par[x] = find(par[x]);
        return par[x];
    }

    // union
    static void union(int x, int y) {

        x = find(x); y = find(y);

        if (x == y) {
            return;
        }

        if (x < y) {
            par[y] = x;
        } else {
            par[x] = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        par = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            par[i] = i;
        }

        int count = 0;

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            if (find(a) == find(b)) {
                count++;
            } else {
                union(a, b);
            }
        }

        // 연결 트리 개수 체크
        Set<Integer> check = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            int x = find(i);
            if (!check.contains(x)) {
                check.add(x);
            }
        }
        System.out.println(count + check.size()-1);
    }
}
