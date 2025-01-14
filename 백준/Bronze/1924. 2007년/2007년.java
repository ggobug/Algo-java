import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int month = Integer.parseInt(inputs[0]);
        int day = Integer.parseInt(inputs[1]);

        int[] dates = {
                0,
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31};

        int total = day;
        for (int i = 0; i < month; i++) {
            total += dates[i];
        }
        total -= 1;
        total %= 7;

        String[] dayOfTheWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        System.out.println(dayOfTheWeek[total]);

    }
}
