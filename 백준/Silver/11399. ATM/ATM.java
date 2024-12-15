// ATM
// https://www.acmicpc.net/problem/11399

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 사람의 수

        // 인출 시간 입력 받기
        int[] costs = new int[N];   // 각 사람들이 돈을 인출하는데 걸리는 시간 배열
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(input[i]);
        }

        // 인출 시간을 최소화하기 위해 오름차순 정렬
        Arrays.sort(costs);

        int minTime = 0;
        for (int i = 0; i < N; i++) {
            minTime += (N - i) * costs[i];
        }
        System.out.println(minTime);
    }
}
