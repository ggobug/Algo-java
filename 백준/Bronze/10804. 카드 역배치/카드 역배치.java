import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] cards;
    public static void main(String[] args) throws IOException {

        cards = new int[20];
        for (int i = 0; i < 20; i++) cards[i] = i + 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            flipCard(start, end);
        }

        StringBuilder sb = new StringBuilder();
        for (int card : cards) {
            sb.append(card).append(" ");
        }
        System.out.println(sb);
    }

    // 카드 순서 뒤집는 함수
    static void flipCard(int start, int end) {
        if (start >= end) return;
        int temp = cards[start];
        cards[start] = cards[end];
        cards[end] = temp;
        flipCard(start + 1, end - 1);
    }

}
