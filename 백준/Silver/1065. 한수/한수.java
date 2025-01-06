import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1보다 크거나 같고, N보다 작거나 같은 한수 찾기
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isHansu(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isHansu(int num) {
        // 끝을 초항으로 해서 초항 구하기
        int a0 = num % 10;

        // 공차 구하기
        int a1 = (num / 10) % 10;
        int d = a1 - a0;
        num /= 100;

        int an = a1;
        while (num != 0) {
            int bn = num % 10;
            if (bn - an != d) {
                return false;
            }
            num /= 10;
            an = bn;
        }

        return true;
    }
}
