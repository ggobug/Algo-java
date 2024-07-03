import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);

            if (a == 0 && b == 0) break;

            // a가 b의 약수라면
            if (b % a == 0) sb.append("factor" + "\n");
            else if (a % b == 0) sb.append("multiple" + "\n");
            else sb.append("neither" + "\n");
        }
        System.out.println(sb);
    }
}
