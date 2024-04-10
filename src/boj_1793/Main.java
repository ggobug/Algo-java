package boj_1793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[251];
        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(3);
        for (int i = 3; i < 251; i++) {
            dp[i] = dp[i-2].multiply(BigInteger.valueOf(2)).add(dp[i-1]);
        }

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(dp[Integer.parseInt(line)]);
        }
    }
}
