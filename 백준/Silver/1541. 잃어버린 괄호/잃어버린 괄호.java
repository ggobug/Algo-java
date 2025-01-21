import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // '+'은 연산하기
        String[] operations = input.split("-");
        int[] nums = new int[operations.length];
        for (int i = 0; i < operations.length; i++) {
            nums[i] = add(operations[i]);
        }

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result -= nums[i];
        }
        System.out.println(result);
    }

    static int add(String operation) {
        String[] numbers = operation.split("\\+");

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

}
