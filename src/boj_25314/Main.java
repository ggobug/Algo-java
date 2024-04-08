package boj_25314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String str = "";

        for (int i = 1; i <= N / 4; i++) {
            str += "long ";
        }
        System.out.println(str + "int");

    }

}
