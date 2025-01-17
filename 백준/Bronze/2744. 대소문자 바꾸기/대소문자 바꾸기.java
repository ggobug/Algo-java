import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] words = br.readLine().toCharArray();
        for (int i = 0; i < words.length; i++) {
            int value = words[i];

            if (value >= 65 && value <= 90) {
                words[i] = (char) (value + 32);
            } else {
                words[i] = (char) (value - 32);
            }
        }
        for (char word : words) {
            System.out.print(word);
        }

    }
}
