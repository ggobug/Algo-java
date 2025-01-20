import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int[] counts = new int[9];   // 요구되는 숫자 개수의 배열
        for (int i = 0; i < N.length(); i++) {
            int num = Integer.parseInt(String.valueOf(N.charAt(i)));
            if (num == 9) {
                counts[6]++;
            } else {
                counts[num]++;
            }
        }
        counts[6] = (counts[6] + 1) / 2;
        System.out.println(Arrays.stream(counts).max().getAsInt());

    }
}
