package boj_14267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] tree;
    static int[] count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == -1) {
                continue;
            }
            tree[x].add(i);
        }

        count = new int[N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            count[x] += y;
        }

        dfs(1);
        for (int i = 1; i <= N; i++) {
            System.out.print(count[i]);
            if (i != N) {
                System.out.print(" ");
            }
        }
    }

    static void dfs(int x) {
        for (int y : tree[x]) {
            count[y] += count[x];
            dfs(y);
        }
    }
}
