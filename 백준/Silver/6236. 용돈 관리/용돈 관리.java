// 용돈 관리
// https://www.acmicpc.net/problem/6236

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사용일수
        int M = Integer.parseInt(st.nextToken()); // 인출 횟수

        int[] days = new int[N];
        int maxExpense = 0;     // 하루 최대 지출
        int totalExpense = 0;   // 전체 지출 합계

        for (int i = 0; i < N; i++) {
            days[i] = Integer.parseInt(br.readLine());
            maxExpense = Math.max(maxExpense, days[i]);
            totalExpense += days[i];
        }

        // 이분 탐색
        int low = maxExpense;
        int high = totalExpense;
        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            // M번 이하로 인출할 수 있는지 체크
            if (canWithdraw(mid, M, days)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    // 인출 금액 K로 M번 이하로 인출 가능한지 확인하는 함수
    private static boolean canWithdraw(int k, int m, int[] days) {
        int withdraws = 1;      // 인출 횟수
        int currentMoney = k;   // 현재 가지고 있는 돈

        for (int expense : days) {
            if (currentMoney < expense) {
                withdraws++;
                currentMoney = k;
            }
            currentMoney -= expense;
        }

        return withdraws <= m;
    }
}
