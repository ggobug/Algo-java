import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        char[][] table = new char[R][C];
        for (int i = 0; i < R; i++) {
            table[i] = br.readLine().toCharArray();
        }

        int low = 0, high = R - 1;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isValid(table, mid, R, C)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    static boolean isValid(char[][] table, int deleteRowCount, int R, int C) {
        Set<String> set = new HashSet<>();

        for (int c = 0; c < C; c++) {
            StringBuilder sb = new StringBuilder();
            for (int r = deleteRowCount; r < R; r++) {
                sb.append(table[r][c]);
            }
            String colString = sb.toString();

            if (!set.add(colString)) {
                return false;
            }
        }

        return true;
    }
}
