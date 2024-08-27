import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }
        // 최대공약수
        int minGap = 0;
        for (int i = 1; i < N; i++) {
            int gap = trees[i] - trees[i - 1];
            minGap = gcd(minGap, gap);
        }

        StringBuilder sb = new StringBuilder();
        sb.append((trees[N - 1] - trees[0]) / minGap + 1 - N);
        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
