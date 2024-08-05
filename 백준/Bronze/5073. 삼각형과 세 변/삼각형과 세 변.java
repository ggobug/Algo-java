import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 입력 종료
            if (a == 0 && b == 0 && c == 0) break;

            // 삼각형 조건 만족하는지 체크
            if (a + b <= c || b + c <= a || c + a <= b) sb.append("Invalid");

            // 세 변의 길이가 모두 같은 경우
            else if (a == b && b == c) sb.append("Equilateral");
            else if (a == b || b == c || c == a) sb.append("Isosceles");
            else sb.append("Scalene");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
