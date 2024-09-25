import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];
        
        // 좌표 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬하기 (y좌표 기준 오름차순, y좌표가 같으면 x좌표 기준 오름차순)
        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        // 정렬된 결과 출력하기
        for (int i = 0; i < N; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }
}
