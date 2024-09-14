import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        StringBuilder result = new StringBuilder();
        
        // 중복 순열
        permutation(0, N, M, new StringBuilder(), result);

        // 최종 결과 한 번에 출력
        System.out.print(result);
    }

    static void permutation(int order, int N, int M, StringBuilder sb, StringBuilder result) {
        // 수열 길이가 M에 도달하면 결과에 추가하고 종료
        if (order >= M) {
            result.append(sb).append("\n");
            return;
        }

        // 수열 추가하기
        for (int i = 1; i <= N; i++) {
            int length = sb.length();
            sb.append(i).append(" ");
            permutation(order + 1, N, M, sb, result);
            sb.setLength(length);
        }
    }

}
