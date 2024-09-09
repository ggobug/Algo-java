import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int N;
        char[] sections;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            N = Integer.parseInt(input);
            int length = (int) Math.pow(3, N);

            // 문자 배열 생성
            sections = new char[length];
            Arrays.fill(sections, '-');
            createCantorSet(sections, 0, length);

            // 칸토어 집합 근사
            sb.append(new String(sections)).append("\n");
        }

        // 칸토어 집합 근사 출력
        System.out.println(sb);

    }

    // 칸토어 집합을 만드는 재귀 메서드
    static void createCantorSet(char[] sections, int start, int length) {
        if (length == 1) {
            return;  // 길이가 1이 되면 더 이상 분할 종료
        }

        int third = length / 3;

        // 가운데 구간을 공백으로 만들기
        Arrays.fill(sections, start + third, start + 2 * third, ' ');

        // 왼쪽과 오른쪽 부분에 대해 재귀 호출
        createCantorSet(sections, start, third);  // 왼쪽 구간
        createCantorSet(sections, start + 2 * third, third);  // 오른쪽 구간
    }

}
