import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        long N = Long.parseLong(parts[0]);
        long M = Long.parseLong(parts[1]);
        System.out.println(Math.abs(N - M));
    }
}
