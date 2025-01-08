// 검증수
// https://www.acmicpc.net/problem/2475

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int result = 0;
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(input[i]) % 10;

            result += num * num;
            result %= 10;
        }
        System.out.println(result);
    }
}
