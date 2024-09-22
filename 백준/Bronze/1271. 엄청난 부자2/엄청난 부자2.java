import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        BigInteger n = new BigInteger(parts[0]);
        BigInteger m = new BigInteger(parts[1]);

        // 몫과 나머지 계산
        BigInteger share = n.divide(m);
        BigInteger remainder = n.remainder(m);

        // 결과 출력
        System.out.println(share);
        System.out.println(remainder);
    }
}
