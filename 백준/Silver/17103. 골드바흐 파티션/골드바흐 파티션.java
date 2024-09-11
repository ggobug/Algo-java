import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] prime = new boolean[1000001];
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (prime[i]) continue;
            for (int j = i*i; j < 1000001; j+=i) {
                prime[j] = true;
            }
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int tmp = sc.nextInt();
            for (int j = 2; j <= tmp/2; j++) {
                if (!prime[j] && !prime[tmp-j])
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}
