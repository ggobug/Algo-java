import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int A = 300;
        int B = 60;
        int C = 10;

        int countA = T / A;
        T %= A;

        int countB = T / B;
        T %= B;

        int countC = T / C;
        T %= C;

        if (T == 0) {
            System.out.println(countA + " " + countB + " " + countC);
        } else {
            System.out.println(-1);
        }
    }
}
