import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansoo = Integer.parseInt(st.nextToken());
        int round = 1;
        jimin = (jimin + 1) / 2;
        hansoo = (hansoo + 1) / 2;
        while (jimin != hansoo) {
            jimin = (jimin + 1) / 2;
            hansoo = (hansoo + 1) / 2;
            round++;
        }
        System.out.println(round);
    }
}
