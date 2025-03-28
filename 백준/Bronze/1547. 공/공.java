// 공
// https://www.acmicpc.net/problem/1547

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        boolean[] isInBall = new boolean[4];
        isInBall[1] = true;

        StringTokenizer st;

        // M번 컵 바꾸기
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a ==b) continue;

            boolean temp = isInBall[a];
            isInBall[a] = isInBall[b];
            isInBall[b] = temp;
        }

        for (int i = 1; i <= 3; i++) {
            if (isInBall[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}
