package boj.boj_2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            if (i == 0) {
                continue;
            }
            arr[i] += arr[i-1];
        }

        // 완탐은 시간초과
        // 집합으로 생각해보기
        Map<Long, Integer> count = new HashMap<>();
        long answer = 0L;
        for (int i = 0; i < N; i++) {

            // (현재 값 - 집합 요소)가 K라면 answer += 1
            long target = arr[i] - K;
            if (target == 0) {
                answer++;
            }
            if (count.containsKey(target)) {
                answer += count.get(target);
            }
            // 키 없는 경우 0 반환
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(answer);

    }
}