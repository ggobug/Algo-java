import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Float> scoreMap = new HashMap<>();
        scoreMap.put('A', 4.0F);
        scoreMap.put('B', 3.0F);
        scoreMap.put('C', 2.0F);
        scoreMap.put('D', 1.0F);
        scoreMap.put('F', 0.0F);

        char[] inputs = br.readLine().toCharArray();
        float score = scoreMap.get(inputs[0]);
        if (score == 0.0f) {
            System.out.println(score);
            return;
        }
        if (inputs[1] == '+') {
            score += 0.3f;
        } else if (inputs[1] == '-') {
            score -= 0.3f;
        }
        System.out.println(score);
    }
}
