import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int totalTime = 0;

        for (char ch : input.toCharArray()) {
            if (ch >= 'A' && ch <= 'C') {
                totalTime += 3;
            } else if (ch >= 'D' && ch <= 'F') {
                totalTime += 4;
            } else if (ch >= 'G' && ch <= 'I') {
                totalTime += 5;
            } else if (ch >= 'J' && ch <= 'L') {
                totalTime += 6;
            } else if (ch >= 'M' && ch <= 'O') {
                totalTime += 7;
            } else if (ch >= 'P' && ch <= 'S') {
                totalTime += 8;
            } else if (ch >= 'T' && ch <= 'V') {
                totalTime += 9;
            } else if (ch >= 'W' && ch <= 'Z') {
                totalTime += 10;
            }
        }

        System.out.println(totalTime);    
    }
}
