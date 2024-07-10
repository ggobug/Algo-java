import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);

        // 약수들 저장
        ArrayList<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                divisors.add(i);
            }
        }

        Collections.sort(divisors);

        if (divisors.size() < K) {
            System.out.println(0);
        } else {
            System.out.println(divisors.get(K - 1));
        }
    }
}
