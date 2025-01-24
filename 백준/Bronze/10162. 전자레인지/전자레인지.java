import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int A = 300;
        int B = 60;
        int C = 10;

        int count = 0;

        int aCount = T / A;
        int bCount = 0;
        int cCount = 0;
        int res = 0;
        while (aCount >= 0) {
            res = T - aCount * A;
            if (res == 0) {
                System.out.println(aCount);
                return;
            }
            bCount = res / B;
            while (bCount >= 0) {
                res = res - bCount * B;
                if (res == 0) {
                    System.out.println(aCount + " " + bCount + " " + cCount);
                    return;
                }
                cCount = res / C;
                while (cCount >= 0) {
                    res = res - cCount * C;
                    if (res == 0) {
                        System.out.println(aCount + " " + bCount + " " + cCount);
                        return;
                    }
                    cCount--;
                }
                bCount--;

            }
            aCount--;
        }
        System.out.println(-1);
    }
}
