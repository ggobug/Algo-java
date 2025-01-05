import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 염기 서열의 길이
        char[] sequence = br.readLine().toCharArray();

        // DNA 변환 규칙 테이블을 배열로 구현
        char[][] table = {
                {'A', 'C', 'A', 'G'},
                {'C', 'G', 'T', 'A'},
                {'A', 'T', 'C', 'G'},
                {'G', 'A', 'G', 'T'}
        };

        // 해독 시작
        for (int i = N - 1; i > 0; i--) {
            int row = getIndex(sequence[i - 1]);
            int col = getIndex(sequence[i]);
            sequence[i - 1] = table[row][col];
        }

        System.out.println(sequence[0]);
    }

    private static int getIndex(char base) {
        switch (base) {
            case 'A': return 0;
            case 'G': return 1;
            case 'C': return 2;
            case 'T': return 3;
            default: throw new IllegalArgumentException("Invalid DNA base: " + base);
        }
    }
}
