package boj.pb_2002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, String> entryTunnel = new HashMap<>();
        Map<String, Integer> exitTunnel = new HashMap<>();

        String input;
        // 대근이가 적은 차량 번호 (터널 입구)
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            entryTunnel.put(i, input);
        }

        // 영식이가 적은 차량 번호 (터널 출구)
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            exitTunnel.put(input, i);
        }

        int ans = 0;

        // 하나하나 추월 여부 판단하기
        for (int i = 0; i < N; i++) {
            // 검사하려는 차량
            String curCar = entryTunnel.get(i);
            int idx = exitTunnel.get(curCar);

            // 먼저 들어온 차량이 나갈 때 뒤에 있으면 안된다.
            for (int j = i - 1; j >= 0; j--) {
                String targetCar = entryTunnel.get(j);
                int targetIdx = exitTunnel.get(targetCar);
                if (targetIdx > idx) {
                    System.out.println("입구 차량 : = " + curCar + " " + idx);
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
