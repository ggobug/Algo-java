package boj_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 1715번 카드 정렬하기
// https://www.acmicpc.net/problem/1715
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> card = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            card.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        while (card.size() > 1) {
            int tmp = card.poll() + card.poll();
            ans += tmp;
            card.add(tmp);
        }
        System.out.println(ans);
    }
}
