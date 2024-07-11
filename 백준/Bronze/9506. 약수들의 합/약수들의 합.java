import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            if (input.equals("-1")) break;

            int num = Integer.parseInt(input);
            Set<Integer> divisors = new HashSet<>();

            for (int i = 1; i <= Math.sqrt(num); i++) {
                // 약수인지
                if (num % i == 0) {
                    divisors.add(i);
                    divisors.add(num / i);
                }
            }
            int sum = divisors.stream().filter(n -> n != num).mapToInt(Integer::intValue).sum();

            if (sum == num) {
                sb.append(num).append(" = ");
                divisors.remove(num);
                sb.append(String.join(" + ", divisors.stream().sorted().map(String::valueOf).toArray(String[]::new)));
            } else {
                sb.append(num).append(" is NOT perfect.");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
