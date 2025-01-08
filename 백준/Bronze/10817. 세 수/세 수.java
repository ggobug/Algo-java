import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int A = Integer.parseInt(parts[0]);
        int B = Integer.parseInt(parts[1]);
        int C = Integer.parseInt(parts[2]);

        int[] nums = new int[3];
        nums[0] = A;
        nums[1] = B;
        nums[2] = C;
        Arrays.sort(nums);
        
        System.out.println(nums[1]);

    }
}
