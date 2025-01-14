import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        BigInteger A = new BigInteger(inputs[0]);
        BigInteger B = new BigInteger(inputs[1]);
        System.out.println(A.add(B));
    }
}
