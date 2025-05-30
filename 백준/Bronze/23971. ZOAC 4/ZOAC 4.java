import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        int N = Integer.parseInt(input[2]);
        int M = Integer.parseInt(input[3]);

        System.out.println((int) Math.ceil((double) H / (N + 1)) * (int)Math.ceil((double) W / (M + 1)));
    }
}
