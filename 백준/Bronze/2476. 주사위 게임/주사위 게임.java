import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int prizeMoney = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int diceA = Integer.parseInt(st.nextToken());
            int diceB = Integer.parseInt(st.nextToken());
            int diceC = Integer.parseInt(st.nextToken());

            if (diceA == diceB && diceB == diceC) {
                prizeMoney = Math.max(prizeMoney, 10000 + diceA * 1000);
            } else if (diceA == diceB) {
                prizeMoney = Math.max(prizeMoney, 1000 + diceA * 100);
            } else if (diceB == diceC) {
                prizeMoney = Math.max(prizeMoney, 1000 + diceB * 100);
            } else if (diceC == diceA) {
                prizeMoney = Math.max(prizeMoney, 1000 + diceC * 100);
            } else {
                prizeMoney = Math.max(prizeMoney, Math.max(diceA, Math.max(diceB, diceC)) * 100);
            }
        }
        System.out.println(prizeMoney);

    }
}
