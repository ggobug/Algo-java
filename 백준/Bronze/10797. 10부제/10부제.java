import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int date = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] cars = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            cars[i] = Integer.parseInt(input[i]);
        }
        int answer = 0;
        for (int car : cars) {
            if (date == car) {
                answer++;
            }
        }
        System.out.println(answer);

    }
}
