// 세탁소 사장 동혁
// https://www.acmicpc.net/problem/2720

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());   // 거스름돈
            int quarter = C / 25;
            int res = C % 25;
            int dime = res / 10;
            res %= 10;
            int nickel = res / 5;
            int penny = res % 5;

            sb.append(quarter + " " + dime + " " + nickel + " " + penny + "\n");
        }
        System.out.println(sb);
    }
}
