import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        int size = (length - 1) / 10 + 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < size; i++) {
            sb.append(input, (i - 1) * 10, i * 10).append("\n");
        }
        sb.append(input, (size - 1) * 10, length);
        System.out.println(sb);
    }
}
