import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> users = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                users = new HashSet<>();
            } else {
                if (!users.contains(input)) {
                    users.add(input);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
