import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 좌표의 빈도수를 저장하는 맵
        Map<Integer, Integer> xCount = new HashMap<>();
        Map<Integer, Integer> yCount = new HashMap<>();

        // 3개의 좌표 입력받기
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xCount.put(x, xCount.getOrDefault(x, 0) + 1);
            yCount.put(y, yCount.getOrDefault(y, 0) + 1);
        }

        // 빈도가 1인 좌표 찾기
        int missingX = 0, missingY = 0;

        for (Map.Entry<Integer, Integer> entry : xCount.entrySet()) {
            if (entry.getValue() == 1) {
                missingX = entry.getKey();
                break;
            }
        }

        for (Map.Entry<Integer, Integer> entry : yCount.entrySet()) {
            if (entry.getValue() == 1) {
                missingY = entry.getKey();
                break;
            }
        }

        System.out.println(missingX + " " + missingY);
    }
}
