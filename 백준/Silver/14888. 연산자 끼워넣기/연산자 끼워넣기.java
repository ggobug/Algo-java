import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] operators, seq;
    static long maxValue = Long.MIN_VALUE;
    static long minValue = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        seq = new int[N]; // N개의 수열
        for (int i = 0; i < seq.length; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operators = new int[4];   // + - x / 의 개수
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // 만들 수 있는 연산 결과값의 최댓값, 최솟값 구하기
        calculate(seq[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    static void calculate(long curValue, int idx) {

        // 모든 연산자를 사용한 경우
        if (idx >= N) {
            // 최댓값, 최솟값
            maxValue = Math.max(maxValue, curValue);
            minValue = Math.min(minValue, curValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) { // 사용할 수 있는 연산자가 남아있으면
                operators[i]--;
                switch (i) {
                    case 0:
                        calculate(curValue + (long) seq[idx], idx + 1);
                        break;
                    case 1:
                        calculate(curValue - (long) seq[idx], idx + 1);
                        break;
                    case 2:
                        calculate(curValue * (long) seq[idx], idx + 1);
                        break;
                    case 3:
                        calculate(curValue / (long) seq[idx], idx + 1);
                        break;
                }
                operators[i]++;
            }
        }
    }



}
