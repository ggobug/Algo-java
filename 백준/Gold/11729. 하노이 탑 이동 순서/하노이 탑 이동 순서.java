import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 원판의 개수

        solution(sb, N);
        System.out.println(sb);
    }

    static void solution(StringBuilder sb, int N) {

        /*
        * 원판 n개를 옮기는 방법
        * 1. 원판 n-1개를 옮긴다.
        * 2. 마지막 원판을 옮긴다.
        * 3. 원판 n-1개를 마지막 원판 위로 옮긴다.
        * f(n) = 2 * f(n-1) + 1
        */

        // 이동 횟수 계산
        sb.append((int) (Math.pow(2, N) - 1)).append('\n');

        // 하노이 탑 이동 순서 출력
        hanoi(N, 1, 2, 3, sb);
    }

    // 원판 이동 횟수
    static void hanoi(int n, int from, int temp, int to, StringBuilder sb) {
        if (n == 0) {
            return;
        }

        // n-1개의 원판을 from에서 temp로 이동
        hanoi(n - 1, from, to, temp, sb);

        // 가장 큰 원판을 from에서 to로 이동
        sb.append(from).append(' ').append(to).append('\n');

        // n-1개의 원판을 temp에서 to로 이동
        hanoi(n - 1, temp, from, to, sb);
    }
}
