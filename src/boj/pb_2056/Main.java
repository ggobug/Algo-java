package boj.pb_2056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;   // 작업 수
    static int[] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        costs = new int[N + 1];

        int total = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            costs[i] = cost;

            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                costs[i] = Math.max(costs[i], costs[Integer.parseInt(st.nextToken())] + cost);
            }

            total = Math.max(total, costs[i]);
        }
        System.out.println(total);
    }
}
