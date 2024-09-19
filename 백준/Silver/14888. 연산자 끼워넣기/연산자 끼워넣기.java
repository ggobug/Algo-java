import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4]; // 덧셈, 뺄셈, 곱셈, 나눗셈
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        N = Integer.parseInt(br.readLine());

        // 숫자 배열 입력
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력 (덧셈, 뺄셈, 곱셈, 나눗셈 순서)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // 백트래킹을 통해 최대값과 최소값 찾기
        backtrack(numbers[0], 1);

        // 결과 출력
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    // 백트래킹 함수
    public static void backtrack(int currentResult, int idx) {
        if (idx == N) { // 모든 수를 다 사용한 경우
            maxResult = Math.max(maxResult, currentResult);
            minResult = Math.min(minResult, currentResult);
            return;
        }

        // 각 연산자에 대해 가능한 경우를 재귀적으로 탐색
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--; // 연산자 사용

                switch (i) {
                    case 0: // 덧셈
                        backtrack(currentResult + numbers[idx], idx + 1);
                        break;
                    case 1: // 뺄셈
                        backtrack(currentResult - numbers[idx], idx + 1);
                        break;
                    case 2: // 곱셈
                        backtrack(currentResult * numbers[idx], idx + 1);
                        break;
                    case 3: // 나눗셈
                        backtrack(currentResult / numbers[idx], idx + 1);
                        break;
                }

                operators[i]++; // 연산자 복구
            }
        }
    }
}