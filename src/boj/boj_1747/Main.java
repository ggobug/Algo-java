package boj.boj_1747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(2);
            return;
        }

        // N보다 크거나 같고ㅡ 소수이면서 팰린드롬인 수 중 가장 작은 수 출력
        for (int i = N; i < 1_000_000_000; i++) {
            if (isPalindrome(i)) {
                boolean isPrime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    System.out.println(i);
                    return;
                }
            }
        }

    }

    static boolean isPalindrome(int n) {
        String str = Integer.toString(n);

        int s = 0;
        int e = str.length() - 1;

        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
