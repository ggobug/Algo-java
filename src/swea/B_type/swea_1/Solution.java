package swea.B_type.swea_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            Set<Integer> set = new HashSet<>();

            int m = 1;
            int count = 1;
            while (true) {

                int num = N * m;
                String str_num = Integer.toString(num);
                for (int i = 0; i < str_num.length(); i++) {

                    int tmp = Character.getNumericValue(str_num.charAt(i));
                    if (!set.contains(tmp)) {
                        set.add(tmp);
                    }
                }

                if (set.size() == 10) {
                    sb.append("#").append(t+1).append(" ").append(num);
                    break;
                }

                m++;
                count++;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
