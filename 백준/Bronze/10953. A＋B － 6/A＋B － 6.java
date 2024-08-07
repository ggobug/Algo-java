import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(",");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            sb.append(a + b).append("\n");
        }
        System.out.println(sb);
    }
}
