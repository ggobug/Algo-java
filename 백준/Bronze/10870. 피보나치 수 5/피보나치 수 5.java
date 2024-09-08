import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
    }

    static int fibo(int x) {

        // 0이나 1인 경우
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        }

        // 2 이상인 경우
        return fibo(x - 1) + fibo(x - 2);
    }
}
