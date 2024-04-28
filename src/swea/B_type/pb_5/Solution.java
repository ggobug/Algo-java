package swea.B_type.pb_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1 ; tc <= 10 ; tc++) {
            sb.append("#" + tc + " ");

            n = Integer.parseInt(br.readLine());

            arr = new char[n + 1];

            for(int i = 1 ; i <= n ; i++) {
                arr[i] = br.readLine().split(" ")[1].charAt(0);
            }
            dfs(1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int cur) {

        if (cur > n) return;

        dfs(cur * 2);
        sb.append(arr[cur]);
        dfs(cur * 2 + 1);
    }
}
