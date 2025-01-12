// 팰린드롬수
// https://www.acmicpc.net/problem/1259

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            // 반복문 종료 조건
            if (input.equals("0")) {
                break;
            }

            if (isPalindrom(input)) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);

    }

    static boolean isPalindrom(String word) {
        char[] chars = word.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
