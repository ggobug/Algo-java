package swea.B_type.swea_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열 편집
public class Solution {
    static int N, M, L; // 수열 길이, 추가 횟수, 출력할 인덱스 번호
    static int[] seq; // 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            seq = new int[N];
            for (int i = 0; i < N; i++) {
                seq[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                if (cmd.equals("D")) {
                    
                } else {

                }
            }
        }
    }
}
