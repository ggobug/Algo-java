import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        long min = Long.parseLong(parts[0]);
        long max = Long.parseLong(parts[1]);

        // min 이상 max 이하인 수 중에 제곱수가 아닌 수 찾기
        // 1 <= min <= 1_000_000_000_000
        // min <= max <= min + 1_000_000

        // 제곱수가 아닌 수를 마킹할 boolean 배열 초기화
        boolean[] isSquareFree = new boolean[(int)(max - min + 1)];

        // 가능한 모든 제곱수를 순회
        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start = Math.max(square, (min + square - 1) / square * square);

            for (long j = start; j <= max; j += square) {
                isSquareFree[(int)(j - min)] = true;
            }
        }

        // 제곱수가 아닌 숫자를 카운트
        int count = 0;
        for (int i = 0; i < isSquareFree.length; i++) {
            if (!isSquareFree[i]) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}
