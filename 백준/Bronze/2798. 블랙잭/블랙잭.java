//블랙잭

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 카드 3장 합 M 이하, 최대로 만들기

        int N = Integer.parseInt(st.nextToken());    // 카드의 수
        int M = Integer.parseInt(st.nextToken());   // 상한선

        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;

        //1.완탐
        for (int a = 0; a < N - 2; a++) {
            for (int b = a + 1; b < N - 1; b++) {
                for (int c = b + 1; c < N; c++) {
                    int sum = cards[a] + cards[b] + cards[c];
                    if (sum <= M && sum > max) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);


    }
}
