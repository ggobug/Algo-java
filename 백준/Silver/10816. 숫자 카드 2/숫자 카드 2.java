// 숫자 카드 2
// https://www.acmicpc.net/problem/10816

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> cardMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            cardMap.put(num, cardMap.getOrDefault(num, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(cardMap.getOrDefault(Integer.parseInt(st.nextToken()), 0));
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
