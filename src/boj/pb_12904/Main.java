package boj.pb_12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        br.close();

        while (S.length() < T.length()) {

            if (T.charAt(T.length() - 1) == 'A') {
                detachA();
            } else {
                detachBAndReverse();
            }
        }

        if (S.equals(T)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    // A 떼기
    static void detachA()
    {
        T = T.substring(0, T.length() - 1);
    }

    // B 떼고 뒤집기
    static void detachBAndReverse()
    {
        T = new StringBuilder(T.substring(0, T.length() - 1)).reverse().toString();
    }
}
