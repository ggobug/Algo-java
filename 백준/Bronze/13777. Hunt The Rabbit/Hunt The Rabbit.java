import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // 입력이 "0"일 때까지 반복
        while (!(input = br.readLine()).equals("0")) {
            int target = Integer.parseInt(input); // 찾고자 하는 숫자 (토끼가 숨겨진 봉투 번호)
            int low = 1;  // 탐색 범위의 하한 (1부터 시작)
            int high = 50; // 탐색 범위의 상한 (50까지)

            StringBuilder sb = new StringBuilder();

            // 이진 탐색 시작
            while (low <= high) {
                int mid = (low + high) / 2; // 중간값 계산
                sb.append(mid).append(" "); // 탐색한 숫자 저장

                if (mid == target) {
                    break; // 찾았으면 종료
                } else if (mid < target) {
                    low = mid + 1; // 중간값보다 크면 오른쪽 범위 탐색
                } else {
                    high = mid - 1; // 중간값보다 작으면 왼쪽 범위 탐색
                }
            }

            // 결과 출력
            System.out.println(sb.toString().trim());
        }
    }
}
