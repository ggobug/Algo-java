import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = null;
        // 3번
        for (int tc = 1; tc <= 3; tc++) {
            input = br.readLine();
            int count = (int) input.chars()
                    .filter(ch -> ch == '1')
                    .count();
            switch (count) {
                case 3:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 1:
                    System.out.println("C");
                    break;
                case 0:
                    System.out.println("D");
                    break;
                case 4:
                    System.out.println("E");
                    break;
            }
        }
    }
}
