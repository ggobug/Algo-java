// 거스름돈
// https://www.acmicpc.net/problem/5585

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pay = Integer.parseInt(br.readLine());
        int res = 1000 - pay;
        int count = 0;

        int[] coins = {500, 100, 50, 10, 5, 1};

        for (int coin : coins) {
            count += res / coin;
            res %= coin;
        }
        System.out.println(count);

    }
}
