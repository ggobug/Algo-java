import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        // 피보나치 수 0, 1 호출 횟수 기억하기
        int[][] fibo = new int[41][2];
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
            fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
        }

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(fibo[n][0] + " " + fibo[n][1] + "\n");
        }
        System.out.println(sb);
    }
}
