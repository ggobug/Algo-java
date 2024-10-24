import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long k = Long.parseLong(input[1]);

        long length = 0;  // 총 자리수 계산
        int digit = 1;    // 현재 자리수
        long count = 9;   // 자리수별 숫자의 개수
        long start = 1;   // 현재 자리수에서의 시작 숫자

        // k번째 자릿수가 속하는 자리수를 찾는 과정
        while (k > length + digit * count && N >= start + count - 1) {
            k -= digit * count;
            length += digit * count;
            digit++;
            count *= 10;
            start *= 10;
        }

        if (k > (N - start + 1) * digit) {
            System.out.println(-1);
        } else {
            long num = (k - 1) / digit + count / 9;
            int idx = (int)((k - 1) % digit);
            System.out.println(Long.toString(num).charAt(idx));
        }
    }
}
