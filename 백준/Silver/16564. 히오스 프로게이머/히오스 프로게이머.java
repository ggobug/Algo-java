// 히오스 프로게이머
// https://www.acmicpc.net/problem/16564

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");

        int N = Integer.parseInt(parts[0]);   // 캐릭터의 개수
        long K = Long.parseLong(parts[1]);   // 올릴 수 있는 레벨의 총합

        long[] levels  = new long[N];    // 캐릭터들 레벨의 배열
        for (int i = 0; i < N; i++) {
            levels [i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(levels);

        long low = levels[0]; // 최소 레벨
        long high = levels[N - 1] + K; // 최대 가능한 레벨
        long answer = low;


        while (low <= high) {
            long mid = (low + high) / 2;
            long requiredLevelUp = 0;
            
            for (long level : levels) {
                if (level < mid) {
                    requiredLevelUp += (mid - level);
                }
            }

            if (requiredLevelUp <= K) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
