import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[9][9];

        int[] indexes = new int[2];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (maxValue < arr[i][j]) {
                    indexes[0] = i + 1;
                    indexes[1] = j + 1;
                    maxValue = arr[i][j];
                }
            }
        }
        System.out.println(maxValue);
        System.out.println(indexes[0] + " " + indexes[1]);


    }
}
