import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Map<String, Double> gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.5);
        gradeMap.put("A0", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B0", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C0", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D0", 1.0);
        gradeMap.put("F", 0.0);

        double sum = 0;
        double cnt = 0;
        while ((input = br.readLine()) != null) {
            String[] parts = input.split(" ");
            if (parts[2].equals("P")) continue;
            cnt += Double.parseDouble(parts[1]);
            sum += Double.parseDouble(parts[1]) * gradeMap.get(parts[2]);
        }
        System.out.println(sum / cnt);
    }
}
