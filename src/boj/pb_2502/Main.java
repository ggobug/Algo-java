package boj.pb_2502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] fibo = new int[31][2];
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        for (int i = 2; i < 31; i++) {
            fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
            fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
//            System.out.println("fibo[i][0], fibo[i][1] = " + fibo[i][0] + " " + fibo[i][1]);
        }

        // LastDay에 LastTteok개
        // fibo[D][0] + fibo[D][1] = K;
        int x = fibo[D - 1][0];
        int y = fibo[D - 1][1];
//        System.out.println("x = " + x);
//        System.out.println("y = " + y);
        int cntX = 1;
        int cntY = 1;

        int sum = K - x - y;
        while (sum >= 0) {

            if (sum % y == 0) {
                cntY = sum / y + 1;
                break;
            }

            sum -= x;
            cntX++;
        }

        System.out.println(cntX);
        System.out.println(cntY);
    }
}
