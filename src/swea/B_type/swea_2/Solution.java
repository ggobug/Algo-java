package swea.B_type.swea_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append("#" + (t+1) + " ");
            if ((M & ((1 << N) - 1)) == ((1 << N) - 1)) {
                sb.append("ON");
            } else {
                sb.append("OFF");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
