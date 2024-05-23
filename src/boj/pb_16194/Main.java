package boj.pb_16194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cardPack = new int[N];
        for (int i = 0; i < N; i++) {
            cardPack[i] = Integer.parseInt(br.readLine());
        }



    }
}
