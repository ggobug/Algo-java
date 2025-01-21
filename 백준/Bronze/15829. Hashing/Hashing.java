import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r = 31;
        int M = 1234567891;

        int L = Integer.parseInt(br.readLine());    // 문자열의 길이
        String str = br.readLine();

        int hash = 0;
        for (int i = 0; i < L; i++) {
            hash += ((str.charAt(i) - 96) * (int) Math.pow(r, i)) % M;
        }
        System.out.println(hash);
    }
}
