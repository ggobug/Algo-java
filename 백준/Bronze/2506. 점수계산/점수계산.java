import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int total = 0;  //총 점수
        int score = 1;  //문제 점수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                total += score++;
            } else {
                score = 1;
            }
        }
        System.out.println(total);
    }
}