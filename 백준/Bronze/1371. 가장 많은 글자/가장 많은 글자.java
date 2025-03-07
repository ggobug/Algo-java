import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] freq = new int[26];

        String input;
        while ((input = br.readLine()) != null) {
            for (char c : input.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    freq[c - 'a']++;
                }
            }
        }

        int maxCount = 0;
        for (int count : freq) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (freq[i] == maxCount) {
                sb.append((char) (i + 'a'));
            }
        }

        System.out.println(sb);
    }
}
