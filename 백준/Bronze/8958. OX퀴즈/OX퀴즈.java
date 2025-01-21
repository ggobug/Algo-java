import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String input = null;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            input = br.readLine();
            int totalScore = 0;

            int size = input.length();
            int point = 1;
            for (int i = 0; i < size; i++) {
                if (input.charAt(i) == 'O') {
                    totalScore += point++;
                } else {
                    point = 1;
                }
            }
            sb.append(totalScore).append("\n");
        }
        System.out.println(sb);
    }
}
