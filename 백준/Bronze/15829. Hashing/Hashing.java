import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r = 31;
        long M = 1234567891;

        int L = Integer.parseInt(br.readLine());    // 문자열의 길이
        String str = br.readLine();

        long hash = 0;
        long rPower = 1;

        for (int i = 0; i < L; i++) {
            int value = str.charAt(i) - 'a' + 1;
            hash = (hash + (value * rPower) % M) % M;
            rPower = (rPower * r) % M;
        }

        System.out.println(hash);
    }
}
