// 숫자의 개수
// https://www.acmicpc.net/problem/2577

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long A = Long.parseLong(br.readLine());
        long B = Long.parseLong(br.readLine());
        long C = Long.parseLong(br.readLine());

        long abc = A * B * C;
        int[] count = new int[10];

        int res;
        while (abc != 0) {
            res = (int) abc % 10;

            for (int i = 0; i < 10; i++) {
                if (res == i) {
                    count[i]++;
                }
            }

            abc /= 10;
        }

        for (int i : count) {
            System.out.println(i);
        }

    }
}
