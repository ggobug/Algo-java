import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");

            sb.append("Case #" + (i + 1) + ": ");
            for (int j = parts.length - 1; j >= 0; j--) {
                sb.append(parts[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
