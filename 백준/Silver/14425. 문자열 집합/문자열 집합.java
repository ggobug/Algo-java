import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);

        Set<String> wordSet = new HashSet<>();
        int result = 0;

        String input;
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            wordSet.add(input);
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine();
            if (wordSet.contains(input)) result++;
        }
        System.out.println(result);
    }
}
