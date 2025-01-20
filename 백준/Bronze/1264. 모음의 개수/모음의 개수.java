import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = null;
        StringBuilder sb = new StringBuilder();
        String target = "aeiouAEIOU";
        
        while (true) {
            input = br.readLine();
            
            // 종료 조건
            if (input.equals("#")) {
                break;
            }
            int count = 0;
            for (int i = 0; i < input.length(); i++) {
                if (target.contains(String.valueOf(input.charAt(i)))) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
