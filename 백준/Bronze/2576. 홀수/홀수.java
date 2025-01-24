import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int oddSum = 0;
        int min = 100;
        int num;
        for (int i = 0; i < 7; i++) {
            if ((num = Integer.parseInt(br.readLine())) % 2 == 1) {
                oddSum += num;
                min = Math.min(min, num);
            }
        }
        if (oddSum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(oddSum);
            System.out.println(min);
        }
    }
}
