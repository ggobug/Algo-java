import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (2)
// https://www.acmicpc.net/problem/15650

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        // 고른 수열은 오름차순이어야 한다.
        // (1 ≤ M ≤ N ≤ 8)
        recursion(N , M, 1, 0, new StringBuilder());

    }

    // 재귀
    static void recursion(int N, int M, int idx, int cnt, StringBuilder sb) {
        // 수열이 완성되었을 때
        if (cnt == M) {
            System.out.println(sb.toString().trim()); // 공백 제거 후 출력
            return;
        }

        // 범위를 벗어나면 종료
        if (idx > N) {
            return;
        }

        // 현재 수를 포함하는 경우
        sb.append(idx).append(" ");
        recursion(N, M, idx + 1, cnt + 1, sb);
        sb.setLength(sb.length() - 2);  // 마지막에 추가한 "숫자 " 부분 제거

        // 현재 수를 포함하지 않는 경우
        recursion(N, M, idx + 1, cnt, sb);
    }
}
