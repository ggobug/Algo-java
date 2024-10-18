// 모자이크
// https://www.acmicpc.net/problem/2539
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    // 좌표를 나타내는 클래스
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 행의 개수
        int M = Integer.parseInt(st.nextToken());   // 열의 개수

        int K = Integer.parseInt(br.readLine());    // 사용할 색종이의 장 수
        int L = Integer.parseInt(br.readLine());    // 잘못 칠해진 칸의 수

        // 잘못 칠해진 칸들을 저장
        Point[] wrongCells = new Point[L];
        int maxRow = 0; // 행 좌표 중 최댓값을 저장할 변수

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            wrongCells[i] = new Point(x, y);
            maxRow = Math.max(maxRow, x); // 행 좌표의 최댓값 갱신=
        }

        // 열 좌표 기준으로 오름차순 정렬
        Arrays.sort(wrongCells, Comparator.comparingInt(p -> p.y));

        // 이분 탐색을 통해 최소 크기 찾기
        int left = maxRow;  // 색종이의 최소 크기는 최대 행 번호
        int right = M;      // 최대 크기는 도화지의 열 크기
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            // 현재 크기의 색종이로 모든 잘못된 칸을 덮을 수 있는지 확인
            if (canCoverAll(wrongCells, K, mid)) {
                answer = mid; // 가능하다면 최소 크기를 줄여서 탐색
                right = mid - 1;
            } else {
                left = mid + 1; // 불가능하면 크기를 늘려서 탐색
            }
        }

        // 답 출력
        System.out.println(answer);
    }

    // 주어진 크기의 색종이로 잘못 칠해진 칸을 덮을 수 있는지 확인하는 함수
    static boolean canCoverAll(Point[] wrongCells, int K, int size) {
        int usedPapers = 1; // 첫 번째 색종이 사용
        int lastCoveredCol = wrongCells[0].y + size - 1; // 첫 번째 색종이가 덮는 열의 끝 지점

        for (Point cell : wrongCells) {
            // 현재 색종이로 덮을 수 없는 열 범위가 나오면 새 색종이를 사용
            if (cell.y > lastCoveredCol) {
                usedPapers++;
                lastCoveredCol = cell.y + size - 1; // 새로 덮는 범위 설정
            }

            // 사용한 색종이 장수가 K를 넘으면 불가능
            if (usedPapers > K) {
                return false;
            }
        }

        // 모든 칸을 덮을 수 있으면 true 반환
        return true;
    }
}