import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine(); // 남은 숫자
        int idx = 0;                // S에서 비교할 위치
        int n = 0;

        while (idx < num.length()) {
            n++;
            char[] cur = Integer.toString(n).toCharArray();
            for (char c : cur) {
                if (idx < num.length() && num.charAt(idx) == c) {
                    idx++;
                }
            }
        }

        System.out.println(n);
    }
}
