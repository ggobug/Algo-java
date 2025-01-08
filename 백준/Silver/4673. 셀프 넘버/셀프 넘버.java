import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97};
        boolean[] selfNumbers = new boolean[10001];

        for (int i = 0; i < 100; i++) {
            selfNumbers[i] = true;
        }

        for (Integer i : arr) {
            selfNumbers[i] = false;
        }

        for (int i = 86; i <= 10000; i++) {
            int sum = addDigit(i);
            if (sum <= 10000) {
                selfNumbers[sum] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10000; i++) {
            if (!selfNumbers[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    // 각 자리수의 합 구하는 메서드
    static int addDigit(int x) {
        int sum = x;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }
}
