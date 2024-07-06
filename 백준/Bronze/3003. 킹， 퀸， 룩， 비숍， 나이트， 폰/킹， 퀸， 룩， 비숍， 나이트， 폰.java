import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] standard = {1, 1, 2, 2, 2, 8};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < standard.length; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(standard[i] - num + " ");
        }
        System.out.println(sb);
    }
}
